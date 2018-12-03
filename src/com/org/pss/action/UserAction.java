package com.org.pss.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.pss.entity.Order;
import com.org.pss.entity.Page;
import com.org.pss.entity.Role;
import com.org.pss.entity.User;
import com.org.pss.service.IUserService;
import com.org.pss.service.Impl.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import util.EnumTypeFormat;
import util.StringUtil;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {
    private String ids;
    private JSONObject jsonObject;//异步请求，也就是ajax请求
    private int userId;//可以根据这个用户id去获取数据表中的用户所有属性
    private String fullName;
    private String code;//验证码
    private int sex;
    private int page;//表示从第几页开始
    private int limit;//表示一页限制多少条数据
    private int opversion;//标志是删除或修改
    private int queryVersion;//标志模糊查询还是全部查询
    private String version;
    private  String validateType;//

    @Autowired
    //@Qualifier("userService")
    private IUserService userService;//和service层相连接起来
    private User user;//entity层
    private File file;
    private String fileFileName;
    private String fileContentType, pwd;
    public String login () {
        jsonObject = new JSONObject();
        boolean isNum = validateType.matches("^[0-9]+$"); //判断传过来的账号是数字与否
        if (isNum)
            user.setUserId(Integer.parseInt(validateType)); //是数字就是根据userId登录,set到User实体类里面
        else
            user.setFullName(validateType.trim()); //不是数字就是根据fullName登录,set到User实体类里面
        boolean flag = userService.ValidateByNameOrID(user);
        if(!flag){
            jsonObject.put("success", false);
            jsonObject.put("errMsg", "请检查账号密码");
        }
        else
           jsonObject.put("success", true);
        return SUCCESS;

    }
    public String register () {
        jsonObject = new JSONObject();
        int result = userService.save_userRegister(user);
        if (result > 0)
            jsonObject.put("success", true);
        else {
            jsonObject.put("success", false);
            jsonObject.put("errMsg", "注册失败");
        }
        return SUCCESS;
    }
    public String userList (){
        if (queryVersion == 1)
            sex = sex == 0 ? -1 : sex;
        else
            sex = -1;
        User user2 = new User(userId == 0 ? -1 : userId, StringUtil.isNotEmpty(fullName) ? fullName.trim() : null, sex);
        List<User> list = null;
        int countUser = 0;
        if (user2.getUserId() == -1 && user2.getSex() == -1 && !StringUtil.isNotEmpty(user2.getFullName())) {
            list = userService.listUser(new User(-1, -1), new Page(page == 0 ? 1 : page, limit == 0 ? 30 : limit));
            countUser = userService.countUser(new User(-1, -1), new Page(page == 0 ? 1 : page, limit == 0 ? 30 : limit));
        }else {
            list =  userService.listUser(user2, new Page(page == 0 ? 1 : page, limit == 0 ? 30 : limit));
            countUser = userService.countUser(user2, new Page(page == 0 ? 1 : page, limit == 0 ? 30 : limit));
        }

        jsonObject = new JSONObject();
        jsonObject.put("msg", "" );
        jsonObject.put("code", 0);
        jsonObject.put("count", countUser);
        JSONArray array = new JSONArray();
        if (list != null) {
            for (User u : list) {
                JSONObject temp = new JSONObject();
                temp.put("userId", u.getUserId());
                temp.put("fullName", u.getFullName());
                temp.put("sex", EnumTypeFormat.formatSex(u.getSex()));
                temp.put("order", u.getOrders());
                temp.put("mpTel", u.getMpTel());
                temp.put("Address", u.getAddress());

                temp.put("isAlived", EnumTypeFormat.formatStateToStr(u.getIsAlived()));
                temp.put("Email", u.getEmail());
                Set<Order> orders = u.getOrders();
                Set<Role> roles = u.getRoles();
                String orderList = "";
                int count = 0;
                for(Order order : orders) {
                    if (count == orders.size() - 1)
                        orderList.concat("" + order.getoId());//后面加了订单名的话把这个改成getNAME
                    else
                        orderList.concat(order.getoId() + ",");
                    count ++;
                }
                temp.put("order", orderList);
                int tempRoleCount = 0;
                String roleNames = "";
                for(Role role : roles) {
                    if (tempRoleCount == roles.size() - 1)
                        roleNames.concat("" + role.getRoleName());//后面加了订单名的话把这个改成getNAME
                    else
                        roleNames.concat(role.getRoleName() + ",");
                    tempRoleCount ++;
                }
                temp.put("roleName", roleNames);
                array.add(temp);
            }
        }
        jsonObject.put("data", array);
        return SUCCESS;
    }

    /**
     * 根据id删除user，可以批量删除
     * @return
     */
    public String delUser () {
        jsonObject = new JSONObject();
        String[] strIds = ids.split(","); //比如ids："1,2,3" ,split之后{"1", "2", "3"}
        int temp = 0;
        int errIndex[] = new int[] {};
        for (String id : strIds) {
            if (StringUtil.isNotEmpty(id)) {
                if (userService.delUser(Integer.parseInt(id)) == 0) {
                    errIndex [temp] = Integer.parseInt(id);
                    temp ++;
                }
            }
        }
        if (errIndex.length == strIds.length) {
            jsonObject.put("success", false);
            jsonObject.put("msg", "删除失败");
        }else {
            jsonObject.put("success", true);
            if (errIndex.length > 0) {
                String errs = "";
                for (int i = 0; i < errIndex.length; i ++) {
                    if (i == errIndex.length - 1)
                        errs.concat("" + errIndex [i]); // 到最后数组的最后一条的话不用追加"," 1,2,3
                    else
                        errs.concat(errIndex + ",");
                }
                jsonObject.put("msg", "删除成功条数为" + (strIds.length - errIndex.length) + "条" + "失败的id为" + errs);
            }else
                jsonObject.put("msg", "删除成功");
        }


        return SUCCESS;
    }
    public String userInfoOp(){ //编辑或添加
        jsonObject = new JSONObject();
        if (opversion == 0)
            user.setUserId(0);
        int n=userService.userInfoOp(user,opversion);
        if (n > 0){
            jsonObject.put("success",true);
        }else {
            jsonObject.put("success",false);
            jsonObject.put("errmsg","保存失败！");
        }
        return SUCCESS;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public int getOpversion() {
        return opversion;
    }

    public void setOpversion(int opversion) {
        this.opversion = opversion;
    }

    public int getQueryVersion() {
        return queryVersion;
    }

    public void setQueryVersion(int queryVersion) {
        this.queryVersion = queryVersion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getValidateType() {
        return validateType;
    }

    public void setValidateType(String validateType) {
        this.validateType = validateType;
    }
}
