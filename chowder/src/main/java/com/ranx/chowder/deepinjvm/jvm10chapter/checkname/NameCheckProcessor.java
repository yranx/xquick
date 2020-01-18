package com.ranx.chowder.deepinjvm.jvm10chapter.checkname;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;


/**
* @Description: 注解处理器
* @author ranx
* @date 2019年12月26日10:40:03
 */

@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class NameCheckProcessor extends AbstractProcessor{

	private NameChecker nameChecker;

	/**
	 * 初始化名称检查插件
	 */
	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		nameChecker = new NameChecker(processingEnv);
	}
	
	/**
	 * 对输入的语法书的各个节点进行名称检查
	 * 把当前Round中的每一个RootElement传递到一个名为NameChecker的检查器中执行名称检查逻辑
	 */
	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		if (!roundEnv.processingOver()) {
			for (Element element : roundEnv.getRootElements()) {
				nameChecker.checkNames(element);
			}
		}
		return false;
	}


	
	
}
