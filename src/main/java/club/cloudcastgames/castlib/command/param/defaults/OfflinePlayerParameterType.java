package club.cloudcastgames.castlib.command.param.defaults;

import club.cloudcastgames.castlib.CastLib;
import club.cloudcastgames.castlib.command.param.ParameterType;
import org.apache.commons.lang.StringUtils;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OfflinePlayerParameterType implements ParameterType<OfflinePlayer> {

    public OfflinePlayer transform(CommandSender sender, String source) {
        if (sender instanceof Player && (source.equalsIgnoreCase("self") || source.equals(""))) {
            return ((Player) sender);
        }

        return (CastLib.getInstance().getServer().getOfflinePlayer(source));
    }

    public List<String> tabComplete(Player sender, Set<String> flags, String source) {
        List<String> completions = new ArrayList<>();

        for (Player player : CastLib.getInstance().getServer().getOnlinePlayers()) {
            if (StringUtils.startsWithIgnoreCase(player.getName(), source)) {
                completions.add(player.getName());
            }
        }

        return (completions);
    }

}