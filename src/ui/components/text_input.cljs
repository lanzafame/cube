(ns ui.components.text-input)

(defn handle-keyup [ev onEnter]
  (when (= (.-keyCode ev) 13)
    (onEnter (-> ev .-target .-value .trim))))

(defn fn-or-noop [f]
  (if (nil? f)
    (fn [])
    f))

(defn text-input [params]
  (let [{id :id
         label :label
         description :description
         input-type :type
         onChange :onChange
         onEnter :onEnter
         defaultValue :default-value
         value :value
         onKeyDown :onKeyDown} params]
  [:div
   [:label.f6.b.db.m2 {:for id} label]
   [:input.input-reset.ba.b--black-20.pa2.mb2.db.w-90 {
                                                       :onKeyDown (fn-or-noop onKeyDown)
                                                       :onKeyUp #(handle-keyup % (fn-or-noop onEnter))
                                                       :onChange (fn-or-noop onChange)
                                                       :type input-type
                                                       :value value
                                                       :default-value defaultValue
                                                       :id id}]
   [:small.f6.lh-copy.black-60.db.mb2 description]]))
