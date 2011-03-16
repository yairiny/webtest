(ns webtest.devapp
  (:use webtest.core)
  (:use ring.middleware.reload)
  (:use ring.adapter.jetty))

(def devapp
  (-> app
      (wrap-reload '(webtest.core))))

(defn start []
  (future (run-jetty #'devapp {:port 8080})))
