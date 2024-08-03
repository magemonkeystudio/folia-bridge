package studio.magemonkey.foliabridge;

import org.bukkit.plugin.Plugin;

public final class FoliaBridge {
    public static void execute(Plugin plugin, Runnable runnable) {
        plugin.getServer().getGlobalRegionScheduler().execute(plugin, runnable);
    }

    public static void runDelayed(Plugin plugin, Runnable runnable, long delay) {
        plugin.getServer().getGlobalRegionScheduler().runDelayed(plugin, t -> runnable.run(), delay);
    }

    public static void runAtFixedRate(Plugin plugin, Runnable runnable, long delay, long period) {
        plugin.getServer()
                .getGlobalRegionScheduler()
                .runAtFixedRate(plugin, t -> runnable.run(), delay < 1 ? 1 : delay, period);
    }

    public static void cancelTasks(Plugin plugin, Plugin cancelReference) {
        plugin.getServer().getGlobalRegionScheduler().cancelTasks(cancelReference);
    }
}