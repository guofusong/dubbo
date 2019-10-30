package fun.hijklmn.mapper;

public interface CommonMapper<T> {


    int deleteByPrimaryKey(String id);


    int insert(T record);


    int insertSelective(T record);


    T selectByPrimaryKey(String jobId);


    int updateByPrimaryKeySelective(T record);


    int updateByPrimaryKey(T record);

}
