package org.futops.ToDoList.dtos;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseResponse<T> {
    private int status;
    private String message;
    private T data;
}
