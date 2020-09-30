package edu.zju.gis.dldsj.server.entity;


import edu.zju.gis.dldsj.server.model.Jsonable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author yanlo yanlong_lee@qq.com
 * @version 1.0 2018/08/01
 * generated by mysql-generator
 */
@Getter
@Setter
@NoArgsConstructor
public class ParallelModel implements Jsonable {
    /**
     * 模型标识，若标识名为XXX，则模型应命名为XXX.jar，本文件命名为XXX.xml
     * jar 包命名规范：首字母大写，多词组合时不需要连接符每个单词都大写
     */
    private String artifactId;
    /**
     * 模型名称
     */
    private String name;
    /**
     * 模型描述
     */
    private String description;
    /**
     * 模型适用类型（按照工具箱分类设置属性，单选项）
     */
    private String usage;
    /**
     * 主类
     */
    private String mainClass;
    /**
     * 分布式计算框架类型 spark，hadoop可选
     */
    private String frameworkType;
    /**
     * 模型开发日期
     */
    private String date;
    /**
     * 版本号
     */
    private String versionId;
    /**
     * 关键字，以英文的“;”分隔
     */
    private String keywords;

    /**
     * 联系单位
     */
    private String groupId;
    /**
     * 模型负责人
     */
    private String authorId;
    /**
     * 邮件地址
     */
    private String email;
    /**
     * jar包即模型文件在服务器的路径
     */
    private String jarPath;
    /**
     * xml描述文件在服务器的路径
     */
    private String xmlPath;
    /**
     * 典型结果示例图片
     */
    private String picPath;
    /**
     * Spark任务进程数
     */
    private Integer numExecutors;
    /**
     * Spark任务驱动节点内存
     */
    private String driverMemory;
    /**
     * Spark任务每个进程的内存
     */
    private String executorMemory;
    /**
     * Spark任务每个进程的线程数
     */
    private Integer executorCores;
    /**
     * Spark任务并行度
     */
    private Integer parallelism;
    /**
     * 控制es是否发布
     */
    private String haveIndex;
    private String userId;
    private Boolean isPublic;

    public ParallelModel(RasterTool rt) {
        this.artifactId = rt.getArtifactId();
        this.name = rt.getName();
        this.description = rt.getDescription();
        this.usage = rt.getUsage();
        this.mainClass = "Raster";
        this.frameworkType = rt.getFrameworkType();
        this.date = rt.getDate();
        this.versionId = rt.getVersionId();
        this.keywords = rt.getKeywords();
        this.groupId = rt.getGroupId();
        this.authorId = rt.getAuthorId();
        this.email = rt.getEmail();
        this.jarPath = "";
        this.xmlPath = "";
        this.picPath = rt.getPicPath();
        this.numExecutors = 0;
        this.driverMemory = "";
        this.executorMemory = "";
        this.executorCores = 0;
        this.parallelism = 0;
        this.haveIndex = "";
        this.userId = "topic3";
        this.isPublic = true;
    }

    @Override
    public String id() {
        return artifactId;
    }
}