package edu.zju.gis.dldsj.server.mapper;

import com.github.pagehelper.Page;
import edu.zju.gis.dldsj.server.base.BaseMapper;
import edu.zju.gis.dldsj.server.entity.RotationFigure;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Jinghaoyu
 * @version 1.0 2020/08/20
 *
 * 轮播图
 */

public interface RotationFigureMapper extends BaseMapper<RotationFigure, Integer> {
    List<RotationFigure> findAll();

    RotationFigure selectByPrimaryKey(Integer id);

    List<RotationFigure> selectById(@Param("id") Integer id, @Param("offset") int offset, @Param("size") int size);

    int ifFigureExist(Integer id);

    Page<RotationFigure> findByPaging(Map param);
}
