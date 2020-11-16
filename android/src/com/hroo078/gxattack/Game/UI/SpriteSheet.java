package com.hroo078.gxattack.Game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.XmlReader;

import java.util.HashMap;

public class SpriteSheet {

    HashMap<String, TextureRegion> sprites;
    Texture texture;

    public SpriteSheet(String filename) {
        try {

            XmlReader xmlReader = new XmlReader();
            XmlReader.Element root = xmlReader.parse(Gdx.files.internal(filename));

            sprites = new HashMap<String, TextureRegion>();
            texture = new Texture(Gdx.files.internal(root.getAttribute("imagePath")));

            for (XmlReader.Element subtexture : root.getChildrenByName("SubTexture")) {

                sprites.put(subtexture.getAttribute("name"), new TextureRegion(
                        texture,
                        Integer.parseInt(subtexture.getAttribute("x")),
                        Integer.parseInt(subtexture.getAttribute("y")),
                        Integer.parseInt(subtexture.getAttribute("width")),
                        Integer.parseInt(subtexture.getAttribute("height"))
                ));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public TextureRegion getSpriteRegion(String name) {
        return sprites.get(name);
    }

}
