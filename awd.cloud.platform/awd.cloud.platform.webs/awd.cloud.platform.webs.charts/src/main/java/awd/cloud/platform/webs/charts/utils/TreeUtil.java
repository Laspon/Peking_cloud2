package awd.cloud.platform.webs.charts.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import awd.framework.common.utils.JSONUtil;
 
/**
 * 树形结构工具类
 *
 * 将一组list对象转成树形结构
 * 该list需符合设定的字段类型
 *
 */
public class TreeUtil {
 
 
    public static Map<String,Object> mapArray = new LinkedHashMap<String, Object>();
 
    public List<TreeNode> menuCommon;
    public List<Object> list = new ArrayList<Object>();
 
    public List<Object> treeMenu(List<TreeNode> menu){
        this.menuCommon = menu;
        for (TreeNode treeNode : menu) {
            Map<String,Object> mapArr = new LinkedHashMap<String, Object>();
            if(treeNode.getParentId().equals("0")){
                setTreeMap(mapArr,treeNode);
                list.add(mapArr);
            }
        }
        return list;
    }
 
    public List<?> menuChild(String id){
        List<Object> lists = new ArrayList<Object>();
        for(TreeNode a:menuCommon){
            Map<String,Object> childArray = new LinkedHashMap<String, Object>();
            if(a.getParentId() .equals(id)){
               setTreeMap(childArray,a);
               lists.add(childArray);
            }
        }
        return lists;
    }
 
    private void setTreeMap(Map<String,Object> mapArr,TreeNode treeNode){
        mapArr.put("id", treeNode.getId());
        mapArr.put("text", treeNode.getText());
        mapArr.put("parentId", treeNode.getParentId());
        List<?> childrens = menuChild(treeNode.getId());
        if(childrens.size()>0){
            mapArr.put("hasChild",true);
        }
        else{
            mapArr.put("hasChildren",false);
        }
        mapArr.put("children", menuChild(treeNode.getId()));
    }
 
    public  static void main(String[] args){
 
        List<TreeNode> treeNodeList = new ArrayList<>();
        TreeNode treeNode1 = new TreeNode("1","0","首页");
        TreeNode treeNode2 = new TreeNode("2","0","订单");
        TreeNode treeNode3 = new TreeNode("3","1","预约");
        TreeNode treeNode4 = new TreeNode("4","2","捐献");
        TreeNode treeNode5 = new TreeNode("5","4","我的订单");
        TreeNode treeNode6 = new TreeNode("6","5","个人中心");
        TreeNode treeNode7 = new TreeNode("7","6","个人中心2");
        TreeNode treeNode8 = new TreeNode("8","99","个人中心3");
        treeNodeList.add(treeNode1);
        treeNodeList.add(treeNode6);
        treeNodeList.add(treeNode5);
        treeNodeList.add(treeNode3);
        treeNodeList.add(treeNode4);
        treeNodeList.add(treeNode2);
        treeNodeList.add(treeNode7);
        treeNodeList.add(treeNode8);
 
 
        TreeUtil treeUtil = new TreeUtil();
        System.out.print(JSONUtil.toJson(treeUtil.treeMenu(treeNodeList)));
 
    }
 
 
}
