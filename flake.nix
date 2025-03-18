{
  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";

  outputs = { self, nixpkgs, ... }@inputs:
  {
    devShells."x86_64-linux".default = let pkgs = inputs.nixpkgs.legacyPackages."x86_64-linux"; in pkgs.mkShell {
      nativeBuildInputs = with pkgs; [
        jdk23
        jetbrains.idea-community
      ];
    };
  };
}
