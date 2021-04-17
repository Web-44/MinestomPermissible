package permissions;

import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.permission.PermissionHandler;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: more tests
// TODO: no
public class TestPermissions {

    private Player player;

    @BeforeEach
    public void init() {
        MinecraftServer.init(); // for entity manager
        player = new Player(UUID.randomUUID(), "TestPlayer", null) {
            @Override
            protected void playerConnectionInit() {
            }

            @Override
            public boolean isOnline() {
                return false;
            }
        };
        player.setPermissionHandler(new PermissionHandler() {
            @Override
            public boolean hasPermission(String permission) {
                return permission.equals("yes");
            }
        });
    }

    @Test
    public void noPermission() {
        assertFalse(player.hasPermission(""));
        assertFalse(player.hasPermission("random.permission"));
    }

    @Test
    public void hasPermission() {
        assertFalse(player.hasPermission("no"));
        assertTrue(player.hasPermission("yes"));
        player.setPermissionHandler(null);
        assertFalse(player.hasPermission("yes"));
    }

    @AfterEach
    public void cleanup() {

    }
}
