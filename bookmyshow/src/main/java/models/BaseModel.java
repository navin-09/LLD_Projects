package models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {
    private int id;
    private Date createdAt;
    private Date lastModifiedAt;

}
