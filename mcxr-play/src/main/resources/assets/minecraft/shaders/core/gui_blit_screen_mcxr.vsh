#version 100

attribute vec3 Position;
attribute vec2 UV;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;

varying vec2 texCoord;

void main() {
    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);

    texCoord = UV;
}
