package edu.zju.gis.dldsj.server.base;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;


/**
 * @author Hu
 * dao接口基类
 * @update zyq 2020/09/23
 */
public interface BaseMapper<T extends Base, ID extends Serializable> {

    /**
     * 插入实体
     */
    int insert(T t);

    /**
     * 删除实体
     */
    int deleteByPrimaryKey(ID id);

    /**
     * 删除实体（批量）
     */
    int batchDelete(List<ID> ids);

    /**
     * 更新实体
     */
    int updateByPrimaryKey(T t);

    /**
     * 查询实体
     */
    T selectByPrimaryKey(ID id);

    /**
     * 查询实体（批量）
     */
    List<T> batchSelect(List<ID> ids);

    /**
     * 查询实体（所有）
     */
    List<T> allSelect();

    /**
     * 根据参数查询对象
     */
    List<T> search(BaseFilter<ID> params);

    /**
     *
     */
    List<T> selectByPage(@Param("offset") int offset, @Param("size") int size);
}
