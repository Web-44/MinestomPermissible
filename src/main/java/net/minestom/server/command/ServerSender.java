package net.minestom.server.command;

import net.minestom.server.command.builder.CommandContext;
import net.kyori.adventure.audience.Audience;
import net.minestom.server.permission.Permission;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Sender used in {@link CommandManager#executeServerCommand(String)}.
 * <p>
 * Although this class implemented {@link CommandSender} and thus {@link Audience}, no
 * data can be sent to this sender because it's purpose is to process the data of
 * {@link CommandContext#getReturnData()}.
 */
public class ServerSender implements CommandSender {
    
    @Override
    public boolean hasPermission(String permission) {
        return true;
    }
}
