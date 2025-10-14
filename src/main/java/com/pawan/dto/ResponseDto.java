
package com.pawan.dto;

// import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
/**
 * @author pawanthapa 
 * ResponseDto objects pass message, errorCode, totalRecords,
 * data, status of the response
 */
public class ResponseDto {
    private String message;
    private int errorCode;
    private int totalRecords;
    private Object data;
    private String status;

    public Object getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    // Explicit constructor for (String, int, int, Object, String)
    public ResponseDto(String message, int errorCode, int totalRecords, Object data, String status) {
        this.message = message;
        this.errorCode = errorCode;
        this.totalRecords = totalRecords;
        this.data = data;
        this.status = status;
    }
}
