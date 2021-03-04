package org.daoPractice.dao;

public class RoleDaoSqls {
    public static final String SELECT_ALL = "SELECT role_id, description FROM role order by role_id";
    public static final String SELECT_BY_ID = "SELECT role_id, description FROM role WHERE role_id = :roleId";
    public static final String UPDATE = "UPDATE role SET description = :description WHERE role_id = :roleId";
    public static final String DELETE_BY_ID = "DELETE FROM role where role_id = :roleId";
}
