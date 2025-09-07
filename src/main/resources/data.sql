INSERT INTO inspire_sessions (session_id, breathe_content, learn_content, quote_content, created_at) VALUES
(UUID(),
'Breathe in, hold for 4 min, breathe out. Do this 5 times.',
'In Java, the meaning of final keyword is not final. It can be a final class, final method, final field, or final variable.',
'Ive learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel. ― Maya Angelou',
NOW()),
(UUID(),
'Breathe: complete five full breath cycles. Each breath cycle (inhale and exhale) should last about 12 seconds.',
'Hiding internal data from the outside world, and accessing it only through publicly exposed methods is known as data encapsulation.',
'Hide nothing, for time, which sees all and hears all, exposes all. - Sophocles',
NOW()),
(UUID(),
'Close your eyes. Breathe slowly as you scan from head to toe, noticing and releasing tension with each exhale.',
'In the Java programming language, an interface is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types.',
'To design is to communicate clearly by whatever means you can control or master. - Milton Glaser',
NOW());

INSERT INTO modules (module_id, module_type, module_content) VALUES
(UUID(),'BREATHE','Breathe deeply and slowly sweep your attention from head to toes, relaxing each area as you go.'),
(UUID(),'LEARN','Interfaces cannot be instantiated—they can only be implemented by classes or extended by other interfaces.'),
(UUID(),'QUOTE','I did then what I knew how to do. Now that I know better, I do better. - Maya Angelou'),
(UUID(),'BREATHE','Inhale slowly, guiding your awareness from your head down to your toes, softening each muscle as you exhale.'),
(UUID(),'LEARN','In the Java language, classes can be derived from other classes, thereby inheriting fields and methods from those classes.'),
(UUID(),'QUOTE','I have learned over the years that when ones mind is made up, this diminishes fear; knowing what must be done does away with fear. - Rosa Parks'),
(UUID(),'BREATHE','Breathe deeply and gently scan your body from crown to feet, releasing tension with every breath out.'),
(UUID(),'LEARN','Cybersecurity is the practice of protecting people, systems and data from cyberattacks by using various technologies, processes and policies.'),
(UUID(),'QUOTE','Where there is a woman there is magic. — Ntozake Shange');
