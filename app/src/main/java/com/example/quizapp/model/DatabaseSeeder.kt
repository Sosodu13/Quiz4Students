package com.example.quizapp.model

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.quizapp.model.data.*

class DatabaseSeeder(private val context: Context) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        // Ajouter des données à la base de données ici
        val db = QuizDatabase.getDatabase(context)
        val conceptDAO = db.conceptdao()
        val concept1 = Concept(1, "Programmation", "Innitiation")
        val concept2 = Concept(2, "Big Data", "Compréhension")
        val concept3 = Concept(3, "Droit", "Maitrise")
        val concept4 = Concept(4, "Economie numérique", "Innitiation")
        val concept5 = Concept(5, "Entreprise X.0", "Compréhension")
        val concept6 = Concept(6, "Fin Tech", "Maitrise")
        val concept7 = Concept(7, "IA", "Innitiation")
        val concept8 = Concept(8, "Innovation technologique", "Compréhension")
        val concept9 = Concept(9, "Sécurité informatique", "Maitrise")
        val concept10 = Concept(10, "Communication", "Innitiation")
        conceptDAO.insertAll(
            concept1,
            concept2,
            concept3,
            concept4,
            concept5,
            concept6,
            concept7,
            concept8,
            concept9,
            concept10
        )

        val concept_ThemeDAO = db.concept_themedao()
        val concept_theme1 = ConceptTheme(1,1,1)
        val concept_theme2 = ConceptTheme(2,2,2)
        concept_ThemeDAO.insertAll(concept_theme1, concept_theme2)

        val coursDAO = QuizDatabase.getDatabase(context).coursdao()
        val cours1 = Cours(1, "Communication digitale", "Innitiation")
        val cours2 = Cours(1, "Communication digitale", "Compréhension")
        val cours3 = Cours(1, "Communication digitale", "Maitrise")
        val cours4 = Cours(1, "Créer son site web", "Innitiation")
        val cours5 = Cours(1, "Créer son site web", "Compréhension")
        val cours6 = Cours(1, "Créer son site web", "Maitrise")
        val cours7 = Cours(1, "Programmation", "Innitiation")
        val cours8 = Cours(1, "Programmation", "Compréhension")
        val cours9 = Cours(1, "Programmation", "Maitrise")
        coursDAO.insertAll(
            cours1,
            cours2,
            cours3,
            cours4,
            cours5,
            cours6,
            cours7,
            cours8,
            cours9,
        )

        val questionDao = db.questiondao()
        val question1 = Question(1,
            "Alice travaille sur un projet de développement logiciel et elle utilise 'Python' comme langage de programmation pour coder ce projet. A quoi lui sert son éditeur de texte ?",
            "F1",
            true,
            1
        )
        val question2 = Question(2,
            "Candice travaille sur un projet de développement logiciel. Elle utilise 'Java' comme langage de programmation pour coder ce projet. Elle doit recourir à un programme informatique qui s'appelle interpréteur pour :",
            "F2",
            false,
            1
        )
        val question3 = Question(3,
            "Romane décide de prendre un serveur virtuel chez un opérateur cloud comme 'OVHcloud' afin d'héberger son site web de e-commerce. Quel est l’avantage de ce choix ?",
            "F3",
            false,
            1
        )
        val question4 = Question(4,
            "Le référencement SEO ( Search Engine Optimization) est un ensemble de techniques qui permettent de positionner un site dans les premiers résultats naturels (c'est-à-dire non payants) des moteurs de recherche. Vanessa souhaite améliorer le référencement SEO de son site internet, pourquoi ?",
            "F4",
            false,
            10
        )
        val question5 = Question(5,
            "Julie a créé une super vidéo et elle souhaite la partager sur tous ses réseaux sociaux, est ce que c'est une bonne idée ?",
            "F5",
            false,
            10
        )
        val question6 = Question(6,
            "Chahinez a écrit un article très intéressant sur LinkedIn mais se demande à quelle heure elle doit le publier pour avoir le maximum de réactions",
            "F6",
            false,
            10
        )
        val question7 = Question(7,
            "Hugo a reçu un mail de l’équipe l’IT support dans son entreprise qui dit  «Attention: tentative de «phishing» avec l'email du directeur ».  A votre avis, qu'est-ce que cela signifie ?",
            "F7",
            false,
            9
        )
        val question8 = Question(8,
            "Magali lance son entreprise et elle doit assurer la confidentialité de ses données. A votre avis, qu'est-ce que cela signifie ?",
            "F8",
            false,
            9
        )
        val question9 = Question(9,
            "Myriam est dans la bibliothèque de son école, elle consulte le site de son compte bancaire via un ordinateur fixe disponible. Le navigateur « Google Chrome » lui propose d'enregistre son mot de passe pour ce site, doit-elle accepter ?",
            "F9",
            false,
            9
        )
        val question10 = Question(10,
            "Flavia visite un site commercial. Un 'chatbot'  apparaît avec le message suivant : 'Bonjour! Posez-nous vos questions'. Il s'agit de :",
            "F10",
            false,
            7
        )
        val question11 = Question(11,
            "Alice discute avec Johan à propos des voitures intelligentes. Elle lui explique qu'elles utilisent la technologie de l’intelligence artificielle pour partager des informations et communiquer entre elles  afin de mieux se déplacer dans la circulation. Johan enrichit cette discussion avec d'autres exemples correspondant également à des technologies d’IA. Il parle de :",
            "F11",
            false,
            7
        )
        val question12 = Question(12,
            "L'intelligence artificielle (IA) est « l'ensemble des théories et des techniques mises en œuvre en vue de réaliser des machines capables de simuler l'intelligence humaine ». Dans cette définition, à quoi fait référence le terme 'intelligence' ?",
            "F12",
            false,
            7
        )
        val question13 = Question(13,
            "Slim travaille sur un projet en « informatique décisionnelle/ business intelligence ». Dans le cadre de ce projet, des données volumineuses sont disponibles dans la base de données de l’entreprise mais difficilement exploitables par les directeurs. Slim va donc créer des tableaux de bord pour chacun, présentant les informations les plus pertinentes pour chaque direction. A votre avis, quel est l'intérêt de ce type de démarche ?",
            "F13",
            false,
            2
        )
        val question14 = Question(14,
            "Hugo a lancé son entreprise l’année dernière et il souhaite mettre en place une stratégie 'data driven'. Cette stratégie consiste à prendre toutes les décisions en se basant sur les données et non sur des analyses ou des perceptions puis les partager à toute l'entreprise. Quel est l'intérêt d'une telle démarche ?",
            "F14",
            false,
            2
        )
        val question15 = Question(15,
            "Yasser a besoin de créer un reporting qui inclut les données liées à l'activité d'approvisionnement de ce matin. Chris lui indique qu'il devra attendre demain car les données ne sont pas encore dans le datawarehouse. A votre avis qu'est-ce que ça veut dire ?",
            "F15",
            false,
            2
        )
        val question16 = Question(16,
            "Le terme entreprise X.0 (2.0, 3.0 ou 4.0)  fait référence aux entreprises connectées et à l'utilisation des nouvelles technologies :",
            "F16",
            false,
            5
        )
        val question17 = Question(17,
            "Antoine travaille sur un projet de construction d'un nouvel entrepôt, il fait appel à des spécialistes qui pourront créer le contenu BIM pour son projet. De quoi s'agit-il ?",
            "F17",
            false,
            5
        )
        val question18 = Question(18,
            "Jean souhaite transformer et digitaliser son entreprise. Il pense à remplacer les employés sur la chaîne de production par des robots. Que doit-il faire ?",
            "F18",
            false,
            5
        )
        val question19 = Question(19,
            "Singapour, Zurich, Oslo, Nantes, Lyon et Montpellier sont considérées comme des exemples de «smart city ». Pourquoi ?",
            "F19",
            false,
            8
        )
        val question20 = Question(20,
            "Alex habite actuellement à Bordeaux et il cherche un appartement pour déménager sur Marseille. Comme il ne pourra pas se déplacer, l’agent immobilier lui propose de se rendre dans les locaux de l’agence à Bordeaux pour faire une visite virtuelle en utilisant un casque VR. De quel type de commerce s'agit-il ?",
            "F20",
            false,
            8
        )
        val question21 = Question(21,
            "Valerya affirme à Quentin que les grands groupes ont du mal à innover. Quentin n'est pas d'accord. Il explique que :",
            "F21",
            false,
            8
        )
        val question22 = Question(22,
            "Le covoiturage est-il un exemple d'économie collaborative ?",
            "F23",
            false,
            4
        )
        val question23 = Question(23,
            "Pourquoi la santé semble-t-elle un domaine pertinent pour déployer des objets connectés ?",
            "F23",
            false,
            4
        )
        val question24 = Question(24,
            "En économie, la disruption désigne le bouleversement d'un marché sur lequel les positions sont établies avec une stratégie inédite. Que nous apprend 'Netflix' sur la disruption ?",
            "F24",
            false,
            4
        )
        val question25 = Question(25,
            "Eli souhaite faire une première levée de fonds pour son entreprise de granulés pour poêles à bois qui ne dégagent pas de CO2. Léa lui propose de se tourner vers le crowdfunding, avec par exemple Wiseed, afin que des particuliers et entrepreneurs puissent investir dans son entreprise. Pourquoi ?",
            "F25",
            false,
            6
        )
        val question26 = Question(26,
            "Comment la blockchain par proof of work permet de se passer d’un tiers de confiance (tels que les banques) ?",
            "F26",
            false,
            6
        )
        val question27 = Question(27,
            "Comment la blockchain par proof of work vérifie qu’une demande de transfert d’argent d’un compte à un autre est légitime ?",
            "F27",
            false,
            6
        )
        val question28 = Question(28,
            "Alice a acheté pour chez elle une machine à café sur internet. Malheureusement, cette dernière ne fonctionne pas. Quel est le délai de rétractation d'un particulier pour renvoyer un article acheté sur internet ?",
            "F28",
            false,
            3
        )
        val question29 = Question(29,
            "Kaspar veut créer un site internet pour sa société commerciale. Selon la loi, il doit obligatoirement préciser :",
            "F29",
            false,
            3
        )
        val question30 = Question(30,
            "Valerya vient d'inventer un système de validation de contrats chiffrés et impossible à modifier sur un système de blockchain respectueux de l'environnement. Valerya devrait-elle déposer un brevet pour protéger son invention ?",
            "F30",
            false,
            3
        )
        questionDao.insertAll(question1, question2)

        val responseDao = db.responsedao()
        val response1Q1 = Response(1, "À écrire le code source de son projet", true, 1)
        val response2Q1 = Response(2,  "À corriger et rectifier les erreurs commises par le programmeur", false, 1)
        val response3Q1 = Response(3,  "À  faire une traduction du code source au langage binaire", false, 1)
        val response4Q1 = Response(4,  "À calculer le temps nécessaire pour exécuter le programme", false, 1)
        val response5Q1 = Response(5,  "Je ne sais pas", false, 1)
        val response1Q2 = Response(6, "Les 3 réponses", true, 2)
        val response2Q2 = Response(7,  "Aucune des réponses", false, 2)
        val response3Q2 = Response(8,  "Convertir son code source en code machine comme le langage qu'une machine utilise pour “dialoguer” avec son processeur et sa mémoire est le binaire et ce n'est pas 'Python'", false, 2)
        val response4Q2 = Response(9,  "Jouer le rôle d’interface entre son projet logiciel et le processeur", false, 2)
        val response5Q2 = Response(10,  "Traiter le code source pendant son fonctionnement et exécuter le programme écrit dans le langage informatique « python »", false, 2)
        val response1Q3 = Response(11,  "Passer d'une logique matérielle à une logique de service. Le but étant de limiter ses investissements tout en se laissant la possibilité d'évoluer facilement en termes de capacité", false, 3)
        val response2Q3 = Response(12,  "Passer d'une logique matérielle à une logique de service sur place. Le service cloud déploie le serveur dans l'entreprise et gère la maintenance", false, 3)
        val response3Q3 = Response(13,  "Passer d'une logique matérielle à une logique de décentralisation. Le service est ainsi déployé sur la blockchain et évolue en fonction des demandes utilisateurs", false, 3)
        val response4Q3 = Response(14,  "Passer d'une logique matérielle à une logique 'all inclusive'. Le serveur déployé dans l'entreprise cliente est alors entièrement géré par OVHcloud qui s'occupe pour l'entreprise l'ensemble des évolutions et maintenances nécessaires", false, 3)
        val response5Q3 = Response(15,  "Je ne sais pas", false, 3)
        val response1Q4 = Response(16,  "Cela permet de capter facilement des clients potentiels. Si l’on n’apparaît pas sur la première page de Google, on est hors jeu.", false, 4)
        val response2Q4 = Response(17,  "Cela permet d'être respectueux des normes écologiques et d'obtenir le label 'site-web vert'", false, 4)
        val response3Q4 = Response(18,  "Cela permet de produire un contenu de qualité sur son site internet", false, 4)
        val response4Q4 = Response(19,  "Cela permet de gagner de l'argent avec son site en se basant sur le nombre de clics par jour", false, 4)
        val response5Q4 = Response(20,  "Je ne sais pas", false, 4)
        val response1Q5 = Response(21,  "Oui. Mais attention, chaque réseau social a ses codes, certains contenus peuvent être communs, d’autres doivent être retravaillés", false, 5)
        val response2Q5 = Response(22,  "Oui évidemment, cela ne nécessite aucune charge de travail supplémentaire. Il suffit d'un « clic » pour publier le contenu sur tous les réseaux sociaux", false, 5)
        val response3Q5 = Response(23,  "Non, elle peut publier la vidéo uniquement sur YouTube", false, 5)
        val response4Q5 = Response(24,  "Non, il vaut mieux poster les photos sur Instagram, les vidéos sur YouTube et TikTok et les articles sur LinkedIn", false, 2)
        val response5Q5 = Response(25,  "Je ne sais pas", false, 5)
        val response1Q6 = Response(26,  "Cela dépend. Il existe des sites qui recensent les horaires et les jours statistiquement favorables, réseau social par réseau social", false, 6)
        val response2Q6 = Response(27,  "Le lundi entre 8h et 9h ou entre 16h et 17h parce que cela correspond aux heures d'arrivée et de départ des entreprises", false, 6)
        val response3Q6 = Response(28,  "A n’importe quel moment, cela n’a pas d’importance", false, 6)
        val response4Q6 = Response(29,  "Cela dépend. Sur un réseau B2B (business to business), c'est avant 9h, entre midi et 14h, puis après 17h. Pour un réseau B2C (business to consumer), c'est entre 14h et 17h", false, 6)
        val response5Q6 = Response(30,  "Je ne sais pas", false, 6)
        val response1Q7 = Response(31,  "Hugo doit faire très attention s'il a reçu un mail qui semble envoyé par son directeur. Il doit le supprimer sans cliquer sur le lien hypertexte qui renvoie vers un faux site afin d’obtenir des données confidentielles", false, 7)
        val response2Q7 = Response(32,  "La boite mail de son directeur a été piratée, des personnes malveillantes ont obtenu des données confidentielles via sa boite mail et il n’arrive pas à récupérer tous les messages", false, 7)
        val response3Q7 = Response(33,  "Hugo va recevoir un nombre important de mails venant de son directeur. Un système d'envoi massif de courriers électroniques utilise le mail du directeur pour envoyer des emails sans intérêt aux collaborateurs de l'entreprise. Hugo doit juste les négliger.", false, 7)
        val response4Q7 = Response(34,  "Je ne sais pas", false, 7)
        val response5Q7 = Response(35,  "", false, 7)
        val response1Q8 = Response(36,  "Les données doivent être lues uniquement par des personnes habilitées et aucune copie illicite ne doit pouvoir être réalisée", false, 8)
        val response2Q8 = Response(37,  "Les données ne doivent pas contenir d'informations erronées", false, 8)
        val response3Q8 = Response(38,  "Les données ne doivent pas pouvoir être altérées à cause d'une intrusion dans le système informatique", false, 8)
        val response4Q8 = Response(39,  "Les données doivent pouvoir être sauvegardées automatiquement", false, 8)
        val response5Q8 = Response(40,  "Je ne sais pas", false, 8)
        val response1Q9 = Response(41,  "Jamais. Elle doit toujours être vigilante quand elle utilise des ordinateurs publics ou partagés. En effet, elle doit protéger ses mots de passe et ne pas oublier de bien se déconnecter de tous ses comptes personnels", false, 9)
        val response2Q9 = Response(42,  "Oui. Comme elle utilise un ordinateur sécurisé de l’école, il n'y a aucun risque que quelqu’un puisse récupérer les informations de son compte bancaire", false,9)
        val response3Q9 = Response(43,  "Oui. Comme cela, ce sera plus simple pour elle de consulter son compte bancaire à chaque fois qu’elle utilise cet ordinateur dans la bibliothèque", false,9)
        val response4Q9 = Response(44,  "Aucune différence. L’essentiel est qu’elle s’assure qu’elle est bien déconnectée de son compte bancaire avant de sortir de l’école", false, 9)
        val response5Q9 = Response(45,  "Je ne sais pas", false, 9)
        val response1Q10 = Response(46,  "Un robot logiciel pouvant dialoguer avec le consommateur en imitant les conversations humaines, à partir d'algorithmes de Machine Learning (ML) et de reconnaissance du langage naturel (NLP).", false, 10)
        val response2Q10 = Response(47,  "Un programme qui met les internautes en communication par téléphone avec un expert disponible afin de répartir la charge de travail au sein d'une équipe support", false, 10)
        val response3Q10 = Response(48,  "Un expert au service à la clientèle, qui doit répondre aux demandes d'information 24 heures sur 24, 7 jours sur 7.", false, 10)
        val response4Q10 = Response(49,  "Un spécialiste de marketing qui veut attirer de nouveaux clients en proposant de nouveaux produits et services.", false, 10)
        val response5Q10 = Response(50,  "Je ne sais pas", false, 10)
        val response1Q11 = Response(51,  "Les 3 réponses", false, 11)
        val response2Q11 = Response(52,  "Toutes les réponses sont fausses", false, 11)
        val response3Q11 = Response(53,  "Recevoir une notification de la banque lorsque quelqu'un effectue une transaction à partir d'un endroit qui se trouve à 1 000 km de son adresse de domicile. Il s'agit de détecter toute fraude potentielle.", false, 11)
        val response4Q11 = Response(54,  "L’utilisation de la reconnaissance vocale comme par exemple Alexa, l'assistant d'Amazon, ou Google Home.", false, 11)
        val response5Q11 = Response(55,  "La capacité à analyser l’imagerie médicale pour les cartographier et les catégoriser. Cela permet d’obtenir un diagnostic plus fiable, par exemple pour les mammographies", false, 11)
        val response1Q12 = Response(56,  "Le programme est capable de s'adapter à son environnement et donc de modifier sa réponse en fonction d'éléments qui n'ont pas été spécifiquement indiqués dans le code", false, 12)
        val response2Q12 = Response(57,  "Le programme est capable de trouver la réponse parmi un ensemble de choix prédéterminés dans le code", false, 12)
        val response3Q12 = Response(58,  "Le programme est en capacité de raisonner et de faire le lien entre différents domaines. Par exemple, entre le marketing, la logistique et les achats", false, 12)
        val response4Q12 = Response(59,  "Le programme est en capacité de remplacer les processus rationnels et cognitifs humains", false, 12)
        val response5Q12 = Response(60,  "Je ne sais pas", false, 12)
        val response1Q13 = Response(61,  "Les tableaux de bord permettent de mettre en lien les données et de simplifier leur lecture. Chaque directeur peut ainsi s'appuyer sur des jeux de données pertinents pour piloter son activité", false, 13)
        val response2Q13 = Response(62,  "Les tableaux de bord permettent d'identifier quels employés ne font pas leur travail afin de leur proposer une rupture conventionnelle et ainsi de pouvoir recruter des employés plus performants", false, 13)
        val response3Q13 = Response(63,  "Les tableaux de bord s'appuient sur des algorithmes de big data qui déduisent automatiquement les informations pertinentes à afficher. Cela permet de remplacer les directeurs", false, 13)
        val response4Q13 = Response(64,  "Les tableaux de bord sont des interfaces virtuelles créées pour la réalité virtuelle. Ils permettent d'analyser en 3 dimensions les liens entre les données", false, 13)
        val response5Q13 = Response(65,  "Je ne sais pas", false, 13)
        val response1Q14 = Response(66,  "Prendre des décisions à partir des données permet de rentrer dans une stratégie basée sur les faits. Ainsi, on n'utilise pas les données pour confirmer ses intuitions mais pour diriger ses actions", false, 14)
        val response2Q14 = Response(67,  "Le but est de stocker un maximum de données en espérant les analyser plus tard et pouvoir mesurer l'impact de ses décisions", false, 14)
        val response3Q14 = Response(68,  "Le plus important n'est pas le chiffre d'affaires ou les clients mais les données. Cela permet de mesurer l'évolution des indicateurs de performance", false, 14)
        val response4Q14 = Response(69,  "Utiliser des logiciels de business intelligence permet d'obtenir des rapports sur les tendances. En les mesurant, Hugo pourra se rassurer sur ses prises de décisions", false, 14)
        val response5Q14 = Response(70,  "Je ne sais pas", false, 14)
        val response1Q15 = Response(71,  "La plupart des entreprises n'analysent pas leurs données en temps réel. Les données sont donc copiées (souvent le soir) vers un datawarehouse, sorte de grosse base de données où on les lie entre elles et les prépare pour être ensuite plus facilement lues", false, 15)
        val response2Q15 = Response(72,  "Chris s'est moqué de lui car il est jeune. Datawarehouse est le nom d'un célèbre entrepôt de LVMH qui a brûlé dans les années 80, détruisant ainsi l'équivalent de plus de 140 millions d'euros de vêtements et accessoires de marque", false, 15)
        val response3Q15 = Response(73,  "Le fait que Yasser ne puisse pas accéder à des données aussi importantes en temps réel est un indicateur que l'entreprise n'a toujours pas commencé sa digitalisation. Il n'est pas normal que des gens doivent saisir ces données dans le logiciel datawarehouse alors qu'elles sont déjà présentes dans les bases de données", false, 15)
        val response4Q15 = Response(74,  "Il doit y avoir un problème dans la copie des données de la base de données principale vers le datawarehouse. Yasser devrait ouvrir un ticket d'incident auprès de son service informatique pour accélérer le dépannage", false, 15)
        val response5Q15 = Response(75,  "Je ne sais pas", false, 15)
        val response1Q16 = Response(76,  "Vrai, une entreprise 2.0 utilise un site, un intranet et les réseaux sociaux, une entreprise 3.0 s'appuie sur le tout-automatisation et de la robotique et la 4.0, celle du digital, le big data / l’analytique et l'intelligence artificielle", false, 16)
        val response2Q16 = Response(77,  "Faux, une entreprise 2.0 correspond à l'entreprise où on peut acheter ses produit en ligne sur un site internet, une entreprise 3.0 où on achète via une application et une entreprise 4.0 où on achète via plusieurs canaux", false, 16)
        val response3Q16 = Response(78,  "Vrai, une entreprise 2.0 utilise les réseaux sociaux pour attirer des nouveaux clients, 3.0 utilise une application mobile et une entreprise 4.0 utilise la réalité virtuelle", false, 16)
        val response4Q16 = Response(79,  "Faux, une entreprise 2.0 travaille uniquement avec des fournisseurs européens, une entreprise 3.0 uniquement des fournisseurs chinois et une entreprise 4.0 uniquement des fournisseurs coréens", false, 16)
        val response5Q16 = Response(80,  "Je ne sais pas", false, 16)
        val response1Q17 = Response(81,  "Modéliser un bâtiment afin d'en créer une version virtuelle. Cela permet ainsi de faciliter les simulations, la construction et la maintenance.   Le BIM signifie Building Information Modeling", false, 17)
        val response2Q17 = Response(82,  "Modéliser les flux logistiques dans le nouvel entrepôt pour optimiser les coûts et faciliter la gestion de stock. Le BIM signifie Business In Modelisation", false, 17)
        val response3Q17 = Response(83,  "Modéliser les flux d’information dans le nouvel entrepôt afin de proposer également un entrepôt de données et de faciliter la gestion des données. Le BIM signifie Business Information Modelisation", false,17)
        val response4Q17 = Response(84,  "Je ne sais pas", false, 17)
        val response5Q17 = Response(85,  "Modéliser les flux logistiques et les flux d'information dans le nouvel entrepôt afin d'optimiser ces flux. Le BIM signifie Be In Modelisation", false, 17)
        val response1Q18 = Response(86,  "Analyser le besoin réel et s'interroger sur : 'par quoi remplacer l'intervention humaine'. Cela peut conduire à des solutions hybrides, dans lesquelles on fait faire une partie des activités par des robots et on maintient une autre partie sous la responsabilité d'un humain", false, 18)
        val response2Q18 = Response(87,  "Trouver des postes adéquats pour les employés qui seront remplacés par des robots.  Il faut réévaluer les compétences de ces employés afin de décider qui garder et à quel poste", false, 18)
        val response3Q18 = Response(88,  "Prévoir un budget très important car un robot coûte au minimum 800 000€, même s'il est rentabilisé en quelques années. En effet, il remplace entre 1 et 4 personnes en fonction du modèle", false, 18)
        val response4Q18 = Response(89,  "Disposer d'un environnement adapté avec des objets connectés, des écrans et surtout une connexion internet fiable et performante, proposant un débit supérieur au giga bit afin de pouvoir faire fonctionner le robot de façon optimale", false, 18)
        val response5Q18 = Response(90,  "Je ne sais pas", false, 18)
        val response1Q19 = Response(91,  "Ces sont des villes connectées qui utilisent l'intelligence artificielle et les nouvelles technologies pour améliorer le quotidien de ses habitants", false, 19)
        val response2Q19 = Response(92,  "Ces sont des villes où la culture est mise en valeur, avec un système éducatif performant parce que basé sur les nouvelles technologies", false, 19)
        val response3Q19 = Response(93,  "Ces sont des villes qui utilisent les réseaux sociaux pour informer leurs habitants des évènements culturels et des actualités", false, 19)
        val response4Q19 = Response(94,  "Ces sont des villes qui mettre en avant la production locale et le développement durable", false, 19)
        val response5Q19 = Response(95,  "Je ne sais pas", false, 19)
        val response1Q20 = Response(96,  "Le V-commerce (virtual commerce) correspond à l’utilisation des technologies immersives pour vendre des produits et des services", false, 20)
        val response2Q20 = Response(97,  "Le M-commerce correspond au Mobile commerce, soit la possibilité de pouvoir acheter ses produits ou services via le téléphone mobile et souvent en situation de mobilité", false, 20)
        val response3Q20 = Response(98,  "Le E-commerce correspond à l'achat responsable (Ecologic commerce ou commerce respectant l'environnement) de biens, services et informations", false, 20)
        val response4Q20 = Response(99,  "Le I-commerce (Immobilier commerce) correspond au fait d'acheter ou louer un logement grâce à un site ou une application", false, 20)
        val response5Q20 = Response(100,  "Je ne sais pas", false, 20)
        val response1Q21 = Response(101,  "Les 3 propositions sont vraies", false, 21)
        val response2Q21 = Response(102,  "Les 3 propositions sont fausses", false, 21)
        val response3Q21 = Response(103,  "Ce n'est pas vrai! Il suffit de regarder les innovations que sortent les grands groupes chaque année pour s'en rendre compte", false, 21)
        val response4Q21 = Response(104,  "Il peut y avoir des blocages liés à la lourdeur des processus, aux temps importants pour prendre des décisions et à l'auto-cannibalisme de ses clients, mais il y a de l'innovation", false, 21)
        val response5Q21 = Response(105,  "Il y a un réel manque d'intrapreneurs pour réaliser, les idées innovantes étant alors rarement mises en oeuvre", false, 21)
        val response1Q22 = Response(106,  "Oui, il repose sur le partage des biens, services ou espaces", false, 22)
        val response2Q22 = Response(107,  "Non, il correspond à l’économie sociale et solidaire en permettant aux gens à faible revenu de voyager", false, 22)
        val response3Q22 = Response(108,  "Non, il correspond à l'économie circulaire car les routes sont remplies de rond-points, surtout en France", false, 22)
        val response4Q22 = Response(109,  "Oui, car il nécessite d'être au moins deux pour pouvoir réaliser le trajet", false, 22)
        val response5Q22 = Response(110,  "Je ne sais pas", false, 22)
        val response1Q23 = Response(111,  "La santé représente des milliard d'euros et travailler en prévention permettrait d'allonger la vie et de réduire les soins curatifs", false, 23)
        val response2Q23 = Response(112,  "La santé est un secteur inquiétant et important pour les gens. Il est donc très simple de leur vendre des objets connectés qui les rassurent et de collecter facilement leurs données de santé", false, 23)
        val response3Q23 = Response(113,  "La santé est un secteur dans lequel les 'clients' sont captifs (ils n'ont pas vraiment le choix). En effet, il y a peu de nouveaux malades chaque année, le public cible est donc connu", false, 23)
        val response4Q23 = Response(114,  "La santé est un domaine bien plus large que la finance ou les loisirs, le retour sur investissement est donc généralement beaucoup plus important", false, 23)
        val response5Q23 = Response(115,  "Je ne sais pas", false, 23)
        val response1Q24 = Response(116,  "Ce que les utilisateurs souhaitent, ce n’est pas forcément ce qu’il y a de mieux mais surtout quelque chose de simple", false, 24)
        val response2Q24 = Response(117,  "Ce qui importe surtout aux utilisateurs, ce sont les films qui ont fait le plus d'entrées en salle", false, 24)
        val response3Q24 = Response(118,  "Le modèle des séries avec un épisode par semaine a encore de l'avenir", false, 24)
        val response4Q24 = Response(119,  "Améliorer son algorithme de recommandation est le seul moyen de rester performant", false, 24)
        val response5Q24 = Response(120,  "Je ne sais pas", false, 24)
        val response1Q25 = Response(121,  "Les banques ont souvent peur de prêter à des entreprises innovantes et jeunes qui ne rentrent pas dans leurs cases habituelles. Le crowdfunding permet d'emprunter directement à des particuliers", false, 25)
        val response2Q25 = Response(122,  "Une plateforme de crowdfunding prête de l'argent gratuitement aux entrepreneurs sous forme de subventions d'Etat. Cela revient donc moins cher", false, 25)
        val response3Q25 = Response(123,  "Les banques qui investissent dans les entreprises demandent en général 40% des parts de l'entreprise, il serait dommage qu'Eli perde le contrôle de son entreprise trop tôt", false, 25)
        val response4Q25 = Response(124,  "Une plateforme de crowdfunding est un réseau social d'entrepreneurs. Ceux qui investissent ont donc une connaissance poussée dans le produit (ici les granulés) et il est plus simple de les convaincre", false, 25)
        val response5Q25 = Response(125,  "Je ne sais pas", false, 25)
        val response1Q26 = Response(126,  "La blockchain remplace le tiers de confiance par une validation informatique vérifiée par des centaines de milliers d'ordinateurs ainsi qu'un registre ouvert et transparent", false, 26)
        val response2Q26 = Response(127,  "La blockchain propose un nouveau tiers de confiance 'virtuel' appelé Satoshi Nakamoto (une autorité virtuelle reconnue de tous)", false, 26)
        val response3Q26 = Response(128,  "La blockchain propose de remplacer le tiers de confiance par la confiance dans chaque utilisateur", false, 26)
        val response4Q26 = Response(129,  "La blockchain propose d'aggréger plusieurs validations de différentes autorités connues en analysant la façon d'assurer le rôle de tiers de confiance", false, 26)
        val response5Q26 = Response(130,  "Je ne sais pas", false, 26)
        val response1Q27 = Response(131,  "Des milliers de pc se partagent le registre des transactions et si plus de la moitié est d'accord pour enregistrer cette transaction, alors elle est considérée comme légitime", false, 27)
        val response2Q27 = Response(132,  "Les demandes arrivent auprès de l'instance virtuelle Satoshi Nakamoto qui valide les transactions en fonction de leur provenance", false, 27)
        val response3Q27 = Response(133,  "Les utilisateurs ont signé le Blockchain-Act et s'engage donc dans une démarche de transferts responsables, les transactions sont donc forcément validées", false, 27)
        val response4Q27 = Response(134,  "Les demandes sont envoyées en fonction du contenu et de la disponibilité des 'grands validateurs' à un minimum de 15 grands validateurs qui, au fil des 'validations' gagnent en indice de confiance", false, 2)
        val response5Q27 = Response(135,  "Je ne sais pas", false, 27)
        val response1Q28 = Response(136,  "14 jours à compter de la réception de la machine", false, 28)
        val response2Q28 = Response(137,  "7 jours à compter de la réception de la machine", false, 28)
        val response3Q28 = Response(138,  "Cela dépend des vendeurs, le délai est généralement noté sur l'article", false, 28)
        val response4Q28 = Response(139,  "30 jours à compter de la réception de la machine", false, 28)
        val response5Q28 = Response(140,  "Je ne sais pas", false, 28)
        val response1Q29 = Response(141,  "Les mentions légales (comme le RCS de l'entreprise ou les Conditions Générales de Vente)", false, 29)
        val response2Q29 = Response(142,  "Le prix de livraison pour chaque article", false, 29)
        val response3Q29 = Response(143,  "Le délai de rétractation pour chaque article", false, 29)
        val response4Q29 = Response(144,  "Les moyens de paiements acceptés", false, 29)
        val response5Q29 = Response(145,  "Je ne sais pas", false, 29)
        val response1Q30 = Response(146,  "Toutes ces réponses", false, 30)
        val response2Q30 = Response(147,  "Oui, car un brevet permet d'obtenir le monopole sur l'exploitation commerciale de l'invention pendant 20 ans", false,30)
        val response3Q30 = Response(148,  "Non, car de toutes façon Valerya n'aura pas les moyens de traîner ses copieurs en justice", false, 30)
        val response4Q30 = Response(149,  "Non, car un dépôt de brevet coûte cher tout comme sa mise à jour et son maintien", false, 30)
        val response5Q30 = Response(150,  "Oui, car un brevet permet de justifier de l'antériorité, c'est à dire que l'on est le premier à l'avoir inventé", false, 30)
        responseDao.insertAll(
            response1Q1,
            response2Q1,
            response3Q1,
            response4Q1,
            response5Q1,
            response1Q2,
            response2Q2,
            response3Q2,
            response4Q2,
            response5Q2,
            response1Q3,
            response2Q3,
            response3Q3,
            response4Q3,
            response5Q3,
            response1Q4,
            response2Q4,
            response3Q4,
            response4Q4,
            response5Q4,
            response1Q5,
            response2Q5,
            response3Q5,
            response4Q5,
            response5Q5,
            response1Q6,
            response2Q6,
            response3Q6,
            response4Q6,
            response5Q6,
            response1Q7,
            response2Q7,
            response3Q7,
            response4Q7,
            response5Q7,
            response1Q8,
            response2Q8,
            response3Q8,
            response4Q8,
            response5Q8,
            response1Q9,
            response2Q9,
            response3Q9,
            response4Q9,
            response5Q9,
            response1Q10,
            response2Q10,
            response3Q10,
            response4Q10,
            response5Q10,
            response1Q11,
            response2Q11,
            response3Q11,
            response4Q11,
            response5Q11,
            response1Q12,
            response2Q12,
            response3Q12,
            response4Q12,
            response5Q12,
            response1Q13,
            response2Q13,
            response3Q13,
            response4Q13,
            response5Q13,
            response1Q14,
            response2Q14,
            response3Q14,
            response4Q14,
            response5Q14,
            response1Q15,
            response2Q15,
            response3Q15,
            response4Q15,
            response5Q15,
            response1Q16,
            response2Q16,
            response3Q16,
            response4Q16,
            response5Q16,
            response1Q17,
            response2Q17,
            response3Q17,
            response4Q17,
            response5Q17,
            response1Q18,
            response2Q18,
            response3Q18,
            response4Q18,
            response5Q18,
            response1Q19,
            response2Q19,
            response3Q19,
            response4Q19,
            response5Q19,
            response1Q20,
            response2Q20,
            response3Q20,
            response4Q20,
            response5Q20,
            response1Q21,
            response2Q21,
            response3Q21,
            response4Q21,
            response5Q21,
            response1Q22,
            response2Q22,
            response3Q22,
            response4Q22,
            response5Q22,
            response1Q23,
            response2Q23,
            response3Q23,
            response4Q23,
            response5Q23,
            response1Q24,
            response2Q24,
            response3Q24,
            response4Q24,
            response5Q24,
            response1Q25,
            response2Q25,
            response3Q25,
            response4Q25,
            response5Q25,
            response1Q26,
            response2Q26,
            response3Q26,
            response4Q26,
            response5Q26,
            response1Q27,
            response2Q27,
            response3Q27,
            response4Q27,
            response5Q27,
            response1Q28,
            response2Q28,
            response3Q28,
            response4Q28,
            response5Q28,
            response1Q29,
            response2Q29,
            response3Q29,
            response4Q29,
            response5Q29,
            response1Q30,
            response2Q30,
            response3Q30,
            response4Q30,
            response5Q30
        )

        val themeDao = db.themedao()
        val theme1 = Theme(1, "theme 1")
        val theme2 = Theme(2, "theme 2")
        themeDao.insertAll(theme1, theme2)

        val theme_coursDAO = db.theme_coursdao()
        val theme_cours1 = ThemeCours(1,1,1)
        val theme_cours2 = ThemeCours(2,2,2)
        theme_coursDAO.insertAll(theme_cours1, theme_cours2)

    }
}
