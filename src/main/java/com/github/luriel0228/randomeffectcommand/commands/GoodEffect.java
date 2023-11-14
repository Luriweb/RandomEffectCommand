package com.github.luriel0228.randomeffectcommand.commands;

import com.github.luriel0228.randomeffectcommand.RandomEffect;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GoodEffect implements CommandExecutor {

    private final RandomEffect plugin;

    public GoodEffect(RandomEffect plugin) {
        this.plugin = plugin;
    }

    private final List<PotionEffectType> goodEffects = Arrays.asList(
            PotionEffectType.SPEED,
            PotionEffectType.FAST_DIGGING,
            PotionEffectType.INCREASE_DAMAGE,
            PotionEffectType.JUMP,
            PotionEffectType.REGENERATION,
            PotionEffectType.DAMAGE_RESISTANCE,
            PotionEffectType.FIRE_RESISTANCE,
            PotionEffectType.WATER_BREATHING,
            PotionEffectType.NIGHT_VISION,
            PotionEffectType.HEALTH_BOOST,
            PotionEffectType.ABSORPTION,
            PotionEffectType.SATURATION,
            PotionEffectType.CONDUIT_POWER,
            PotionEffectType.DOLPHINS_GRACE,
            PotionEffectType.HERO_OF_THE_VILLAGE
    );

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("플레이어만 이 명령어를 사용할 수 있습니다.");
            return true;
        }

        Player player = (Player) sender;

        Random random = new Random();
        PotionEffectType randomEffect = goodEffects.get(random.nextInt(goodEffects.size()));

        int duration = args.length >= 2 ? parseDuration(args[1]) * 20 : 600;
        int amplifier = args.length >= 3 ? parseAmplifier(args[2]) : 1;

        player.addPotionEffect(new PotionEffect(randomEffect, duration, amplifier));

        player.sendMessage(ChatColor.GREEN + "이로운 역할: 랜덤한 효과를 얻었습니다 - " + randomEffect.getName());

        return true;
    }

    private int parseDuration(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 600;
        }
    }

    private int parseAmplifier(String input) {
        try {
            return Math.max(0, Integer.parseInt(input));
        } catch (NumberFormatException e) {
            return 1;
        }
    }
}
