(ns spinner.core.desktop-launcher
  (:require [spinner.core :refer :all])
  (:import [com.badlogic.gdx.backends.lwjgl LwjglApplication]
           [org.lwjgl.input Keyboard])
  (:gen-class))

(defn -main
  []
  (LwjglApplication. spinner "spinner" 800 600)
  (Keyboard/enableRepeatEvents true))
