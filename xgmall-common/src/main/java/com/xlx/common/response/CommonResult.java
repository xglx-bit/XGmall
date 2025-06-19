package com.xlx.common.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
// ================Successful scene==================
    /**
     * @return default return successful status without data null
     */
    public static CommonResult<Void> success(){
        return new CommonResult<>(0,"Operate successfully!",null);
    }

    /**
     * @param data return information
     * @return  Return with data
     */
    public static <E> CommonResult<E> success(E data){
        return new CommonResult<>(0,"Operate successfully!",data);
    }

    /**
     * Return with custom message and data
     * @param message successful information
     * @param data return data
     * @return custom message and data
     */
    public static <E> CommonResult<E> success(String message,E data){
        return new CommonResult<>(0,message,data);
    }

    public static <E> CommonResult<E> success(Integer code ,String message,E data){
        return new CommonResult<>(code,message,data );
    }

//    ===================Failure scene===================

    /**
     * Return with custom message
     * @param message error message
     * @return prompt information
     */
    public static CommonResult<Void> error(String message){
        return new CommonResult<>(1,message,null);
    }

    /**
     * Return with custom code and message
     * @param code status code
     * @param message error message
     * @return prompt information
     */
    public static CommonResult<Void> error (Integer code ,String message){
        return new CommonResult<>(code,message,null);
    }

//    ============Chained call==============
    public CommonResult<T> withMessage(String message){
        this.message =message;
        return this;
    }

    public CommonResult<T> withCode(int code){
        this.code = code;
        return this;
    }
}
