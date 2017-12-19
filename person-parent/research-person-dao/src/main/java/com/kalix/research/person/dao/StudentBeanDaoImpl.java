package com.kalix.research.person.dao;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.dao.CommonMethod;
import com.kalix.research.person.api.dao.IStudentBeanDao;
import com.kalix.research.person.dto.model.StudentDTO;
import com.kalix.research.person.entities.StudentBean;

/**
 * Created by Administrator on 2017/3/3.
 */
public class StudentBeanDaoImpl extends BaseAdminDao<StudentBean,Long> implements IStudentBeanDao {
    @Override
    public JsonData getAllRelations(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        String sql = "select t.* from " +
                " (select b.id, a.id as userId, a.code, a.name, a.sex, a.email, a.phone, a.mobile, " +
                " b.majorId, b.instructor, b.identificationCard, b.birthday, b.nation, b.placeOfOrigin, " +
                " b.politicalStatus, b.joinPartyDate, b.address, b.postalcode, b.homePhone, b.province, " +
                " b.entranceYear, b.trainingLevel, b.period, b.version_, c.name as majorName, b.updateDate " +
                " from sys_user a " +
                " left join " + super.getTableName() + " b on a.id = b.userid " +
                " left join sys_organization c on b.majorId = c.id " +
                " where a.usertype = 1) t";
        sql += CommonMethod.createWhereCondition(jsonStr, sort);
        jsonData = this.findByNativeSql(sql, page, limit, StudentDTO.class);
        return jsonData;
    }
}
