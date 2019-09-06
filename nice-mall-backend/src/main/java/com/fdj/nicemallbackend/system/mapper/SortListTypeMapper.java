package com.fdj.nicemallbackend.system.mapper;

import com.fdj.nicemallbackend.system.entity.SortListName;
import com.fdj.nicemallbackend.system.entity.SortListType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xns
 * @since 2019-09-01
 */
@Mapper
public interface SortListTypeMapper extends BaseMapper<SortListType> {

    void save(SortListType sortListType1);

    SortListType selectId(@Param("sortListNameId") Integer sortListNameId,@Param("sortListTypeName") String sortListTypeName);


    List<String> selectBysortListNametId(Integer sortListId);

    List<Integer> selectPartId(String field);
}
