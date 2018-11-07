/**
 * 通用返回结果类型
 * @author LinkinStar
 */
public class CommonResponse<T> {
    /** 返回状态码 **/
    private int code;
    /** 返回信息 **/
    private String message;
    /** 返回数据 **/
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
