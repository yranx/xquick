package com.ranx.chowder.study.dataStructure.linearTable;

/**
 * 序号越界
 * @author ranx
 * @create 2018-08-20 17:12
 **/
public class OutOfBoundaryException extends RuntimeException {
    public OutOfBoundaryException(String err) {
        super(err);
    }
}
