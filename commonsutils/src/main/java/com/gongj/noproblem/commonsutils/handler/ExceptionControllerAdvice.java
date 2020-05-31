package com.gongj.noproblem.commonsutils.handler;
import com.gongj.noproblem.commonsutils.ApiException;
import com.gongj.noproblem.commonsutils.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局处理异常
 */
@RestControllerAdvice(basePackages = {"com.gongj.noproblem"})
@Slf4j
public class ExceptionControllerAdvice {

    /**
    * @Description validation校验异常
     * @param e
    * @Author gongj
    * @Date 2020/5/31 0:08
    **/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo MethodArgumentNotValidException(MethodArgumentNotValidException e){
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResultVo.error().message(objectError.getDefaultMessage());
    }

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public ResultVo error(Exception e) {
        e.printStackTrace();
        return ResultVo.error().message("执行了全局异常处理..");
    }
    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ResultVo ApiException(ApiException e){
        log.error(e.getMessage());
        return ResultVo.error().code(e.getCode()).message(e.getMessage());
    }
}
