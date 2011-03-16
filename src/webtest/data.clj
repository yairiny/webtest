(ns webtest.data
  (:require [clj-time.core :as dt]))

(def *data*
  [{:date (dt/date-time 2011 03 15)
    :type :strength
    :notes "easy training session, focused on posture"}
   {:date (dt/date-time 2011 03 14)
    :type :running :subtype :sprints
    :duration 20
    :notes "6x200m sprints, only did 4 and then was sick, fastest lap - 38s"}
   {:date (dt/date-time 2011 03 15)
    :type :strength
    :notes "easy training session, focused on posture"}
   {:date (dt/date-time 2011 03 14)
    :type :running :subtype :sprints
    :duration 20
    :notes "6x200m sprints, only did 4 and then was sick, fastest lap - 38s"}
   {:date (dt/date-time 2011 03 15)
    :type :strength
    :notes "easy training session, focused on posture"}
   {:date (dt/date-time 2011 03 14)
    :type :running :subtype :sprints
    :duration 20
    :notes "6x200m sprints, only did 4 and then was sick, fastest lap - 38s"}])

(defn get-all-records []
  *data*)
