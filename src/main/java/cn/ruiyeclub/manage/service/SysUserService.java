package cn.ruiyeclub.manage.service;

import cn.ruiyeclub.manage.dto.param.*;
import cn.ruiyeclub.manage.entity.SysResource;
import cn.ruiyeclub.manage.entity.SysRole;
import cn.ruiyeclub.manage.entity.SysUser;
import cn.ruiyeclub.manage.dto.result.SysUserResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户名查找用户
     * @param name 用户名
     * @return User
     */
    SysUser findUserByName(String name,boolean hasResource);

    /**
     * 根据ID查找用户
     * @param id ID
     * @return User
     */
    SysUser findUserById(String id,boolean hasResource);

    /**
     * 用户登录操作
     * @param SignInParam 登录信息
     */
    void signIn(SignInParam signInParam);

    /**
     * 获取当前登录用户信息
     * @return UserVO
     */
    SysUserResult getCurrentUser();

    /**
     * 获取当前登录用户所有的权限标示
     * @return UserVO
     */
    List<String> getAllPermissionTag();

    /**
     * 用户角色资源匹配
     * @param roles 用户角色集
     * @return 资源集合
     */
    List<SysResource> userRolesRegexResource(List<SysRole> roles);


    /**
     * 获取所有用户（分页）
     * @param pageParam 过滤条件
     * @return RequestResult
     */
    IPage<SysUserResult> getAllUserBySplitPage(PageParam pageParam);

    /**
     * 用户状态改变
     * @param userId 用户ID
     * @param status 状态码
     */
    void statusChange(String userId, Integer status);

    /**
     * 删除用户
     * @param userId 用户ID
     */
    void removeUser(String userId);

    /**
     * 添加用户
     * @param addDTO 用户数据DTO
     */
    void add(UserAddParam addDTO);

    /**
     * 更新用户数据
     * @param id 用户id
     * @param updateDTO 用户数据DTO
     */
    void update(String id, UserUpdateParam updateDTO);

    /**
     * 更新用户角色关联
     * @param user
     * @return
     */
    void updateUserRole(SysUser user);

    /**
     * 重置用户密码
     * @param resetPasswordParam
     */
    void resetPassword(ResetPasswordParam resetPasswordParam);
}
