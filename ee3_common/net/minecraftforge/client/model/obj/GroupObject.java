package net.minecraftforge.client.model.obj;

import java.util.ArrayList;

import net.minecraft.client.renderer.Tessellator;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GroupObject {

    public String name;
    public ArrayList<Face> faces = new ArrayList<Face>();
    public int glDrawingMode;
    
    public GroupObject() {
        
        this("");
    }
    
    public GroupObject(String name) {

        this(name, GL11.GL_TRIANGLES);
    }
    
    public GroupObject(String name, int glDrawingMode) {
        
        this.name = name;
        this.glDrawingMode = glDrawingMode;
    }

    public void render() {

        if (faces.size() > 0) {
            
            Tessellator tessellator = Tessellator.instance;
            
            tessellator.startDrawing(glDrawingMode);
            
            for (Face face : faces) {
                face.addFaceForRender(tessellator);
            }
            
            tessellator.draw();
        }
    }
}
