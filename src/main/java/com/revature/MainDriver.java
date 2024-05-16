package com.revature;

import com.revature.utilities.RequestMapper;

import io.javalin.Javalin;
import io.javalin.openapi.plugin.OpenApiPlugin;
import io.javalin.openapi.plugin.redoc.ReDocPlugin;
import io.javalin.openapi.plugin.swagger.SwaggerPlugin;


public class MainDriver {

    public static void main(String[] args) {
        // leave this code as is: if you change it you will most likely break the application
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(it -> {
                    it.anyHost();
                });
            });
            config.registerPlugin(new OpenApiPlugin(pluginConfig -> {
                pluginConfig.withDefinitionConfiguration((version, definition) -> {
                    definition.withInfo(info -> info.setTitle("Javalin OpenAPI example"));
                });
            }));
            config.registerPlugin(new SwaggerPlugin());
            config.registerPlugin(new ReDocPlugin());

        });
        RequestMapper.setUpEndPoints(app);
        app.start(7000);
        System.out.println("Check out ReDoc docs at http://localhost:7000/redoc");
        System.out.println("Check out Swagger UI docs at http://localhost:7000/swagger-ui");
    }

}
