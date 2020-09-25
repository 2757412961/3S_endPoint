package edu.zju.gis.dldsj.server.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jiarui
 * @date 2020/8/31
 */

@Getter
@Setter
@ToString(callSuper = true)
public class GroupMember {
    private String id;
    private String name;
    private String group;
    private String workContent;
    private String photo;
    private String email;
}