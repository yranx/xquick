package com.ranx.chowder.deepinjvm.jvm10chapter.checkname;

import java.util.EnumSet;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner7;
import javax.tools.Diagnostic.Kind;

/**
* @Description: 命名检查器
* 程序名称规范的编译器插件：如果程序命名不合规范，将会输出一个变异期
* @author ranx
* @date 2019年12月26日10:40:03
 */
public class NameChecker {

	private final Messager messager;
	
	NameCheckScanner nameCheckScanner = new NameCheckScanner();

	public NameChecker(ProcessingEnvironment processingEnv) {
		this.messager = processingEnv.getMessager();
	}
	
	public void checkNames(Element element) {
		nameCheckScanner.scan(element);
	}
	
	/**
	 * 名称检查器实现类
	 * 以Visitor模式访问抽象语法树中元素
	 */
	private class NameCheckScanner extends ElementScanner7<Void, Void> {

		@Override
		public Void visitVariable(VariableElement e, Void p) {
			/**
			 * 如果这个Variable是枚举或常量， 则按大写命名检查，否则按照驼峰命名法检查
			 */
			if (e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null || heuristicallyConstant(e)) {
				checkAllCaps(e);
			} else {
				checkCamelCase(e, false);
			}
			return null;
		}

		/**
		 * 检查Java类
		 */
		@Override
		public Void visitType(TypeElement e, Void p) {
			scan(e.getTypeParameters(), p);
			checkCamelCase(e, true);
			super.visitType(e, p);
			return null;
		}

		/**
		 * 检查方法命名是否合法
		 */
		@Override
		public Void visitExecutable(ExecutableElement e, Void p) {
			if (e.getKind() == ElementKind.METHOD) {
				Name name = e.getSimpleName();
				if (name.contentEquals(e.getEnclosingElement().getSimpleName())) {
					messager.printMessage(Kind.WARNING, "一个普通方法" + name + "不应当与类名重复，避免与构造函数产生混淆", e);
					checkCamelCase(e, false);
				}
			}
			super.visitExecutable(e, p);
			return null;
		}
		
		private boolean heuristicallyConstant(VariableElement e) {
			if (e.getEnclosingElement().getKind() == ElementKind.INTERFACE) {
				return true;
			} else if (e.getKind() == ElementKind.FIELD && e.getModifiers()
					.containsAll(EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL))) {
				return true;
			} else {
				return false;
			}
		}
		/**
		 * 检查传入的Element是否符合驼峰式命名规则
		 * @param e
		 * @param initialCaps
		 */
 		private void checkCamelCase(Element e, boolean initialCaps) {
			String name = e.getSimpleName().toString();
			boolean prviousUpper = false;
			boolean conventional = true;
			int firstCodePoint = name.codePointAt(0);
			if (Character.isUpperCase(firstCodePoint)) {
				prviousUpper = true;
				if (!initialCaps) {
					messager.printMessage(Kind.WARNING, "名称 " + name + "应当以小写字母开头", e);
					return;
				}
			} else if (Character.isLowerCase(firstCodePoint)) {
				if (!initialCaps) {
					messager.printMessage(Kind.WARNING, "名称 " + name + "应当以大写字母开头", e);
					return;
				}         
			} else {
				conventional = false;
				if (conventional) {
					int cp = firstCodePoint;
					for (int i=Character.charCount(cp); i<name.length(); i+=Character.charCount(cp)) {
						cp = name.codePointAt(i);
						if (Character.isUpperCase(cp)) {
							if (prviousUpper) {
								conventional = false;
								break;
							}
							prviousUpper = true;
						} else {
							prviousUpper = false;
						}
					}
				}
				
				if (!conventional) {
					messager.printMessage(Kind.WARNING, "名称 " + name + "应当符合驼峰式命名法", e);
				}
			}
		}
		
		private void checkAllCaps(Element e) {
			String name = e.getSimpleName().toString();
			boolean conventional = true;
			int firstCodePoint = name.codePointAt(0);
			
			if (!Character.isUpperCase(firstCodePoint)) {
				conventional = false;
			} else {
				boolean previousUnderscore = false;
				int cp = firstCodePoint;
				for (int i= Character.charCount(cp); i<name.length(); i+=Character.charCount(cp)) {
					cp = name.codePointAt(i);
					if (cp == (int)'_') {
						if (previousUnderscore) {
							conventional = false;
							break;
						}
						previousUnderscore = true;
					} else {
						previousUnderscore = false;
						if (!Character.isUpperCase(cp) && !Character.isDigit(cp)) {
							conventional = false;
							break;
						}
					}
				}
			}
			if (!conventional) {
				messager.printMessage(Kind.WARNING, "常量 " + name + "应当全部以大写字母或下划线命名，并且以字母开头", e);
			}
		}
	}
}
