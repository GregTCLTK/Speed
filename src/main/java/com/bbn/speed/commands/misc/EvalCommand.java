package com.bbn.speed.commands.misc;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EvalCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getAuthor().getId().equals("477141528981012511")) {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

            try {
                engine.eval("var imports = new JavaImporter(java.io, java.lang, java.util);");
            } catch (ScriptException ex) {
                ex.printStackTrace();
            }
            engine.put("msg".toLowerCase(), event.getMessage());
            engine.put("e".toLowerCase(), event);
            engine.put("jda".toLowerCase(), event.getJDA());
            engine.put("message".toLowerCase(), event.getMessage());
            engine.put("guild".toLowerCase(), event.getGuild());
            engine.put("channel".toLowerCase(), event.getChannel());
            engine.put("author".toLowerCase(), event.getAuthor());
            engine.put("member".toLowerCase(), event.getMember());
            engine.put("self".toLowerCase(), event.getGuild().getSelfMember());
            engine.put("out".toLowerCase(), System.out);

            ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

            service.schedule(() -> {

                long startExec = System.currentTimeMillis();
                Object out;

                try {
                    StringBuilder script = new StringBuilder();
                    for (int i = 0; i < args.length; i++) {
                        args[i] = args[i].replace("```java", "").replace("```", "");
                        script.append(i == args.length - 1 ? args[i] : args[i] + " ");
                    }
                    out = engine.eval(script.toString());

                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .addField("Input", "```java\n\n" + script + "```", false)
                            .addField("Output", "```java\n\n" + out.toString() + "```", false)
                            .addField("Timing", System.currentTimeMillis() - startExec + " milliseconds", false)
                            .setColor(Color.GREEN)
                            .build()).queue();
                } catch (Exception ex) {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .addField("Error", "```java\n\n" + ex.getMessage() + "```", false)
                            .addField("Timing", System.currentTimeMillis() - startExec + " milliseconds", false)
                            .setColor(Color.RED)
                            .build()).queue();

                }

                service.shutdownNow();

            }, 0, TimeUnit.MILLISECONDS);
        }
    }
}
