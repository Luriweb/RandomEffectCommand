package com.github.luriel0228.randomeffectcommand;

import com.github.luriel0228.randomeffectcommand.commands.BadEffect;
import com.github.luriel0228.randomeffectcommand.commands.GoodEffect;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomEffect extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("이로운효과").setExecutor(new GoodEffect());
        getCommand("해로운효과").setExecutor(new BadEffect());
    }

}
