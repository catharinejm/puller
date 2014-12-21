(ns puller.core
  (:import [java.net ServerSocket]))

(defn create-socket
  ^ServerSocket [port]
  (ServerSocket. port))

(defn listen
  [port]
  (let [sock (future (.accept (create-socket port)))]
    (loop [s (deref sock 500 sock)]
      (if (identical? s sock)
        (do (println "waiting...")
            (recur (deref s 500 s)))
        (println "connected!")))))

(defn -main [& args]
  (listen 3000)
  (shutdown-agents))
