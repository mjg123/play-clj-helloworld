(defproject spinner "0.0.1-SNAPSHOT"
  :description "indescribable"

  ;; TODO: we probably don't need _all_ these
  :dependencies [[com.badlogicgames.gdx/gdx "1.9.3"]
                 [com.badlogicgames.gdx/gdx-backend-lwjgl "1.9.3"]
                 [com.badlogicgames.gdx/gdx-box2d "1.9.3"]
                 [com.badlogicgames.gdx/gdx-box2d-platform "1.9.3"
                  :classifier "natives-desktop"]
                 [com.badlogicgames.gdx/gdx-bullet "1.9.3"]
                 [com.badlogicgames.gdx/gdx-bullet-platform "1.9.3"
                  :classifier "natives-desktop"]
                 [com.badlogicgames.gdx/gdx-platform "1.9.3"
                  :classifier "natives-desktop"]

                 [org.clojure/clojure "1.8.0"]
                 [play-clj "1.1.1"]]

  :aot [spinner.core.desktop-launcher]
  :main spinner.core.desktop-launcher)
