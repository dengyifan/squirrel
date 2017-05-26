package com.yifan.squirrel.browser.basicdata.config;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by yifan on 2017/5/25.
 */
@Service
public class ModuleManageService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleManageService.class);

    private static PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

    private static final String PACKAGE_PREFIX = "com/yifan/";
    private static final String VIEWS_FROM = "/server/META-INF/views/";
    private static final String VIEWS_TO = "/WEB-INF/views/";
    private static final String TEMPLATES_FROM = "/server/META-INF/templates/";
    private static final String TEMPLATES_TO = "/WEB-INF/templates/";
    private static final String SCRIPTS_FROM = "/server/META-INF/scripts/";
    private static final String SCRIPTS_TO = "/scripts/";
    private static final String STYLES_FROM = "/server/META-INF/styles/";
    private static final String STYLES_TO = "/styles/";
    private static final String IMAGES_FROM = "/server/META-INF/images/";
    private static final String IMAGES_TO = "/images/";

    private ServletContext servletContext;

    public ModuleManageService(ServletContext servletContext) {
         this.servletContext = servletContext;
    }


    public void moduleInit() {
        LOGGER.info("---------------------ModuleManageEvent begin----------------------");
        export(servletContext);
        LOGGER.info("---------------------ModuleManageEvent end----------------------");
    }

    public void export(ServletContext servletContext) {
        export(servletContext, VIEWS_FROM, VIEWS_TO, "");
        export(servletContext, TEMPLATES_FROM, TEMPLATES_TO, "");
        export(servletContext, SCRIPTS_FROM, SCRIPTS_TO, "");
        export(servletContext, STYLES_FROM, STYLES_TO, "");
        export(servletContext, IMAGES_FROM, IMAGES_TO, "");

    }

    private void export(ServletContext servletContext, String from, String to, String suffix) {
        try {
            if(LOGGER.isInfoEnabled()) {
                LOGGER.info("[ModuleManageEvent] servlet root dir: " + servletContext.getRealPath("/"));
            }

            Resource[] resources = resolver.getResources("classpath*:" + PACKAGE_PREFIX +"**" + from + "**" + suffix);
            if(resources != null && resources.length > 0) {


                for(int k = 0; k < resources.length; k++) {
                    Resource resource = resources[k];

                    try {
                        String path = resource.getURL().getPath();
                        int j = path.lastIndexOf(from);
                        String pathHeader = path.substring(0, j);
                        int i = pathHeader.lastIndexOf(47);
                        String module = path.substring(i + 1, j);
                        String page = path.substring(j + from.length());
                        String dist = to + module + "/" + page;
                        File file = new File(servletContext.getRealPath(dist));
                        File dir;
                        if(!file.getName().matches("^.*[.].*$")) {
                            dir = new File(file.getPath() + "\\" + File.separator);
                            createDirectory(dir);
                        }

                        dir = file.getParentFile();
                        createDirectory(dir);

                        if(LOGGER.isInfoEnabled()) {
                            LOGGER.info("[ModuleManageEvent] release resource: " + dist);
                        }

                        OutputStream out = new FileOutputStream(file);
                        InputStream in = resource.getInputStream();
                        IOUtils.copy(in, out);

                        file.setLastModified(resource.lastModified());

                        IOUtils.closeQuietly(out);
                        IOUtils.closeQuietly(in);

                    } catch (Exception var20) {
                        LOGGER.error(var20.getMessage());
                    }
                }
            }

        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    private void createDirectory(File dir) {
        if(dir.exists()) {
            deleteDir(dir);
        }


        boolean mk = dir.mkdirs();
        if(!mk) {
            LOGGER.error("create dir failure!");
        }

        if(LOGGER.isInfoEnabled()) {
            LOGGER.info("[ModuleManageEvent] create dir: " + dir);
        }
    }


    private boolean deleteDir(File dir) {

        if (dir.isDirectory()) {
            String[] children = dir.list();

            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        return true;

    }


    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
