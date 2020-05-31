package com.gongj.noproblem.commonsutils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  //生成有参数构造方法
@NoArgsConstructor   //生成无参数构造
public class ApiException extends RuntimeException {

    private int code;
    private String message;
}
