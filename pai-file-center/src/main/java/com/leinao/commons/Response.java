package com.leinao.commons;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import io.swagger.annotations.ApiModel;

/**
*
*@author wangsf
*@date 2017年3月15日 下午12:59:23
*
*/
@ApiModel(value = "接口操作返回值")
public class Response<T> {

    protected ResponseMessage message;

    protected T data;

    public Response() {
        this(null, null);
    }

    public Response(T data) {
        this(null, data);
    }

    public Response(ResponseMessage message) {
        this.message = message;
    }

    public Response(ResponseMessage message, T data) {
        this.message = message;
        this.data = data;
    }

    public ResponseMessage getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response<?> that = (Response<?>) o;

        return Objects.equal(this.message, that.message) &&
                Objects.equal(this.data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(message, data);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("message", message)
                .add("data", data)
                .toString();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Response<Void> ok() {
        return new Response(ResponseMessage.ok(), null);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> Response<T> ok(T data) {
        return new Response(ResponseMessage.ok(), data);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Response<Void> error() {
        return new Response(ResponseMessage.error(), null);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> Response<T> error(T data) {
        return new Response(ResponseMessage.error(), data);
    }

	public void setMessage(ResponseMessage message) {
		this.message = message;
	}

	public void setData(T data) {
		this.data = data;
	}
    
    
}

