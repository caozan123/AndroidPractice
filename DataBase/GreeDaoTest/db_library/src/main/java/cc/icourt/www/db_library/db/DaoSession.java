package cc.icourt.www.db_library.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import cc.icourt.www.db_library.data.Clazz;
import cc.icourt.www.db_library.data.Student;

import cc.icourt.www.db_library.db.ClazzDao;
import cc.icourt.www.db_library.db.StudentDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig clazzDaoConfig;
    private final DaoConfig studentDaoConfig;

    private final ClazzDao clazzDao;
    private final StudentDao studentDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        clazzDaoConfig = daoConfigMap.get(ClazzDao.class).clone();
        clazzDaoConfig.initIdentityScope(type);

        studentDaoConfig = daoConfigMap.get(StudentDao.class).clone();
        studentDaoConfig.initIdentityScope(type);

        clazzDao = new ClazzDao(clazzDaoConfig, this);
        studentDao = new StudentDao(studentDaoConfig, this);

        registerDao(Clazz.class, clazzDao);
        registerDao(Student.class, studentDao);
    }
    
    public void clear() {
        clazzDaoConfig.clearIdentityScope();
        studentDaoConfig.clearIdentityScope();
    }

    public ClazzDao getClazzDao() {
        return clazzDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

}