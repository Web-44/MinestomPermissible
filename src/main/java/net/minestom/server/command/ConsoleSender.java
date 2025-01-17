package net.minestom.server.command;

import net.kyori.adventure.audience.MessageType;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the console when sending a command to the server.
 */
public class ConsoleSender implements CommandSender {
    private static final PlainComponentSerializer PLAIN_SERIALIZER = PlainComponentSerializer.plain();
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleSender.class);

    @Override
    public void sendMessage(@NotNull String message) {
        LOGGER.info(message);
    }

    @Override
    public void sendMessage(@NotNull  Identity source, @NotNull Component message, @NotNull MessageType type) {
        // we don't use the serializer here as we just need the plain text of the message
        this.sendMessage(PLAIN_SERIALIZER.serialize(message));
    }
    
    @Override
    public boolean hasPermission(String permission) {
        return true;
    }

    @Override
    public boolean isConsole() {
        return true;
    }

    @Override
    public ConsoleSender asConsole() {
        return this;
    }
}
