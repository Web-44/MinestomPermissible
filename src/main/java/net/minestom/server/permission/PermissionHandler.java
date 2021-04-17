package net.minestom.server.permission;

import org.jetbrains.annotations.NotNull;

public interface PermissionHandler {

    /**
     * Gets if this handler has the permission with the name {@code permission}.
     *
     * @param permission the permission name
     * @return true if the handler has the permission, false otherwise
     */
    public boolean hasPermission(@NotNull String permission);

}
