package edu.zju.gis.dldsj.server.controller;

import edu.zju.gis.dldsj.server.base.BaseController;
import edu.zju.gis.dldsj.server.common.Page;
import edu.zju.gis.dldsj.server.common.Result;
import edu.zju.gis.dldsj.server.constant.CodeConstants;
import edu.zju.gis.dldsj.server.entity.Geodata;
import edu.zju.gis.dldsj.server.entity.searchPojo.GeodataSearchPojo;
import edu.zju.gis.dldsj.server.service.GeodataService;
import edu.zju.gis.dldsj.server.utils.fs.FsManipulator;
import edu.zju.gis.dldsj.server.utils.fs.FsManipulatorFactory;
import edu.zju.gis.dldsj.server.utils.fs.LocalFsManipulator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author Jiarui
 * @date 2020/8/26
 * @author: zjh
 * @date: 20201012
 */

@Controller
@CrossOrigin
@RequestMapping("/geodata")
@Slf4j
public class GeodataController extends BaseController<Geodata, GeodataService, String, GeodataSearchPojo> {

    @Value("${settings.hdFsUri}")
    private String hdfsUri;

    @Value("${settings.lFsUri}")
    private String lfsUri;

    /**
     * 按照type1 第一级目录来分类
     *
     * @param type
     * @param page
     */
    @RequestMapping(value = "/bytype1", method = RequestMethod.GET)
    @ResponseBody
    public Result getByType1(@RequestParam String type, Page page) {
        return Result.success().setBody(service.selectByType1(type, page));
    }

    /**
     * 按照type2 第二级目录来分类
     *
     * @param type
     * @param page
     */
    @RequestMapping(value = "/bytype2", method = RequestMethod.GET)
    @ResponseBody
    public Result getByType2(@RequestParam String type, Page page) {
        return Result.success().setBody(service.selectByType2(type, page));
    }

    /**
     * 按照source来分类
     *
     * @param source
     * @param page
     */
    @RequestMapping(value = "/bysource", method = RequestMethod.GET)
    @ResponseBody
    public Result getBySource(@RequestParam String source, Page page) {
        return Result.success().setBody(service.selectBySource(source, page));
    }

    /**
     * 按照userName来选取
     *
     * @param userName
     * @param page
     */
    @RequestMapping(value = "/byuserName", method = RequestMethod.GET)
    @ResponseBody
    public Result getByUserName(@RequestParam String userName, Page page) {
        return Result.success().setBody(service.selectByUserName(userName, page));
    }

    /**
     * distinct 根据输入字段名称，返回结果的唯一不同值与对应数量
     *
     * @param field
     */
    @RequestMapping(value = "/dis", method = RequestMethod.GET)
    @ResponseBody
    public Result getdis(@RequestParam String field, Page page) {
        Map<String, String> res = service.getDistinctField(field);
        return Result.success().setBody(res);
    }

    /**
     * 根据输入的id，更新数据库中下载次数的字段
     *
     * @param id
     */
    @RequestMapping(value = "/downloadplus", method = RequestMethod.GET)
    @ResponseBody
    public Result updateDownload(@RequestParam String id) {
        service.downloadTimesPlus(id);
        return Result.success().setBody(id + "update success");
    }

    /**
     * 返回下载数量最多的五条数据
     */
    @RequestMapping(value = "/populardata", method = RequestMethod.GET)
    @ResponseBody
    public Result getPopularData() {
        return Result.success().setBody(service.getPopularData());
    }


    // -----------------------------------------------------------------------------------------------------------------

    // 通过表单插入数据
    @RequestMapping(value = "/insertByForm", method = RequestMethod.POST)
    @ResponseBody
    public Result insertByForm(@SessionAttribute("role") String role, HttpServletRequest request) {
        return service.insertByForm(role, request);
    }

    // 通过ID 下载数据
    @RequestMapping(value = "/downloadByid", method = RequestMethod.GET)
    @ResponseBody
    public Result downloadByid(String id, HttpServletResponse response) {
        return service.downloadByid(id, response);
    }

    @RequestMapping(value = "/insertAndUp2hdfs", method = RequestMethod.PUT)
    @ResponseBody
    public Result insertAndUp2hdfs(@RequestBody Geodata t) {
        return service.insertAndUp2hdfs(t);
    }

    @RequestMapping(value = "/downFromhdfs", method = RequestMethod.GET)
    @ResponseBody
    public Result downFromhdfs(String id, String fileDirectory) {
        return service.downFromhdfs(id, fileDirectory);
    }

    /**
     * 上传 文件
     */
    @RequestMapping(value = "/uploadFromLocal", method = RequestMethod.GET)
    @ResponseBody
    public Result uploadFromLocal(String filePath) {
        return Result.success().setBody(service.uploadFromLocal(hdfsUri, filePath));
    }

    /**
     * 下载 文件
     */
    @RequestMapping(value = "/downloadFromHDFS", method = RequestMethod.GET)
    @ResponseBody
    public Result downloadFromHDFS(String hdfsPath, String fileDirectory) {
        return Result.success().setBody(service.downloadFromHDFS(hdfsUri, hdfsPath, fileDirectory));
    }


    /**
     * 测试上传、下载
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Result test() {
        return Result.success().setBody(service.test(hdfsUri));
    }


}
