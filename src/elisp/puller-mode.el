(defun puller-load-line-comment ()
  (interactive)
  (let ((lnum (save-excursion
                (beginning-of-line)
                (1+ (count-lines 1 (point))))))
    (insert "Line: ")
    (insert (number-to-string lnum))))

(define-minor-mode puller-mode
  "Pull request source integration"
  :lighter " puller"
  :keymap (let ((map (make-sparse-keymap)))
            (define-key map (kbd "C-c C-c") 'puller-load-line-comment)
            map))

