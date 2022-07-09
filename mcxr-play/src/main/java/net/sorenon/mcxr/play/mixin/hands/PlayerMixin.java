package net.sorenon.mcxr.play.mixin.hands;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.sorenon.mcxr.play.MCXRPlayClient;
import net.sorenon.mcxr.play.PlayOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public abstract class PlayerMixin extends Entity {

    @Unique
    private boolean isActive() {
        //noinspection ConstantConditions
        return MCXRPlayClient.MCXR_GAME_RENDERER.isXrMode() && (LivingEntity) (Object) this instanceof LocalPlayer;
    }

    public PlayerMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @SuppressWarnings("InvalidInjectorMethodSignature")
    @ModifyVariable(method = "travel", ordinal = 3, at = @At(value = "STORE", ordinal = 0))
    double changeSwimDirection(double in) {
        if (isActive()) {
            Vec3 result = PlayOptions.swimDirection.getLookDirection();
            if (result != null) {
                return result.y;
            }
        }
        return in;
    }
}
