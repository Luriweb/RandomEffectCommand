package com.github.luriel0228.randomeffectcommand;

import com.github.luriel0228.randomeffectcommand.commands.BadEffect;
import com.github.luriel0228.randomeffectcommand.commands.GoodEffect;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class RandomEffect extends JavaPlugin {

    @Override
    public void onEnable() {
        setExecutor();
    }

    private void setExecutor() {
        PluginCommand GoodEffect = getCommand("이로운효과");
        Objects.requireNonNull(GoodEffect).setExecutor(new GoodEffect(this));

        PluginCommand BadEffect = getCommand("해로운효과");
        Objects.requireNonNull(BadEffect).setExecutor(new BadEffect(this));
    }

}
