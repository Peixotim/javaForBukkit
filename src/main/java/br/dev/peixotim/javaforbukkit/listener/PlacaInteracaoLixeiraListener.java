package br.dev.peixotim.javaforbukkit.listener;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;
import org.bukkit.block.sign.SignSide;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import static net.kyori.adventure.text.format.TextColor.fromCSSHexString;

public class PlacaInteracaoLixeiraListener implements Listener {
    public static final String TAG_CABECALHO = "[lixeira]";
    public static final String CABECALHO_PLACA_ESTILIZADA = "[Lixeira]";
    public static final TextColor COR_CABECALHO = fromCSSHexString("#8c04db");

    private final LegacyComponentSerializer serializer = LegacyComponentSerializer.legacySection();

    @EventHandler
    public void onCriarPlaca(SignChangeEvent event) {
        String cabecalho = event.getLine(0);

        if (cabecalho != null && cabecalho.equalsIgnoreCase(TAG_CABECALHO)) {
            Component titulo = Component.text(CABECALHO_PLACA_ESTILIZADA).color(COR_CABECALHO);
            Component subtitulo = Component.text("Clique para abrir!").decorate(TextDecoration.ITALIC);

            event.setLine(0, serializer.serialize(titulo));
            event.setLine(1, serializer.serialize(subtitulo));
        }
    }

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent event) {
        var bloco = event.getClickedBlock();

        if (bloco != null && bloco.getState() instanceof Sign sign) {
            SignSide side = sign.getSide(Side.FRONT);

            String textoCabecalho = side.getLine(0);

            Component componenteEsperado = Component.text(CABECALHO_PLACA_ESTILIZADA).color(COR_CABECALHO);
            String textoEsperado = serializer.serialize(componenteEsperado);

            if (textoCabecalho.equals(textoEsperado)) {
                event.setCancelled(true);

                Inventory inventory = Bukkit.createInventory(null, 54, Component.text("Lixeira"));
                var player = event.getPlayer();
                player.openInventory(inventory);
            }
        }
    }
}