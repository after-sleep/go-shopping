package org.after.sleep.shopping.common.exception;

import lombok.Data;
import org.after.sleep.shopping.common.enums.ResponseEnum;

/**
 * @author liujianjian
 * @date 2018/6/3 9:37
 */
@Data
public class BizException extends Exception {
    private String code;
    private boolean needLog = true;

    public BizException(String message) {
        super(message);
    }

    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(ResponseEnum re) {
        super(re.getMessage());
        this.code = re.getCode();
    }

    public BizException(ResponseEnum re, boolean needLog) {
        super(re.getMessage());
        this.code = re.getCode();
        this.needLog = needLog;
    }
}
