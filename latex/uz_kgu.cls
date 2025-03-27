% Modified by P.I.Troshin 12.02.2024, version 2.99
\input {article.cls}
\usepackage[T2A]{fontenc}
\usepackage[utf8]{inputenc}
\usepackage[russian]{babel}
%\usepackage[russian,english]{babel}
\usepackage{amsmath}
\usepackage{amsthm}
\usepackage{amssymb}
\usepackage{amsfonts}
\usepackage[dvips]{graphicx}
\usepackage[dvips]{color}
\usepackage{floatflt}
\usepackage{array}
\usepackage{multicol}
\usepackage{textcase}
\usepackage{fancyhdr}
\usepackage{tabularx}
\usepackage{amsopn}
\usepackage{subfigure}
\usepackage{cite}

%\usepackage[all]{xy}
%\usepackage[mathscr]{eucal}

% %\usepackage[centerlast,small]{caption2}
% \usepackage[center,small]{caption2}
% \renewcommand{\captionlabeldelim}{.}

% (new) изменяем Надпись к таблице
\usepackage[small]{caption}
\DeclareCaptionFormat{hfillstart}{\hfill#1#2#3\par}
\captionsetup[table]{format=hfillstart,labelsep=newline,justification=centering,position=above, name=\CYRT\cyra\cyrb\cyrl.}
\captionsetup[figure]{labelsep=period}

% (new) центрируем иллюстрации:
\renewenvironment{figure}[1][\fps@figure]{
  \edef\@tempa{\noexpand\@float{figure}[#1]} 
  \@tempa\centering}{\end@float}

% (new) Make all figures and tables use '!htb' position by default:
\def\fps@figure{!htb}
\def\fps@table{!htb}

% (new)центрируем таблицы:
\renewenvironment{table}[1][\fps@table]{
  \edef\@tempa{\noexpand\@float{table}[#1]} 
  \@tempa\centering}{\end@float}

\righthyphenmin=2
\emergencystretch=5pt
\hfuzz=2pt
\mathsurround=0.1em
\clubpenalty=1000%
\widowpenalty=1000%
\brokenpenalty=2000%
\frenchspacing%
\tolerance=9000%
\hbadness=1500%
\doublehyphendemerits=50000%
\finalhyphendemerits=25000%
\adjdemerits=50000%
\pagestyle{myheadings}
\setlength{\topmargin}{-0.75cm}%{-1.5cm}
\setlength{\headheight}{1.0cm}
%----------------------
\setlength{\headsep}{0.65cm} %g_n
\setlength{\textheight}{21.72cm}
%\setlength{\oddsidemargin}{1.5cm} %gggg для двусторонней печати
\setlength{\oddsidemargin}{1.25cm}
\setlength{\evensidemargin}{1.25cm}
\setlength{\textwidth}{13.3cm}
%\hoffset=1.31cm

%----------------------
\renewcommand{\baselinestretch}{1.0}


\newcounter{section1} \setcounter{section1}{1}
\newcounter{Theorem*} \setcounter{Theorem*}{0}
\newcounter{Corollary*} \setcounter{Corollary*}{0}
\newcounter{Remark*} \setcounter{Remark*}{0}
%\newcounter{Theorem_s} \setcounter{Theorem_s}{0}
%\newcounter{Proposal_s} \setcounter{Proposal_s}{0}
%\newcounter{Definition_s} \setcounter{Definition_s}{0}

\theoremstyle{plain}
\newtheorem{Theorem}{\hskip\parindent Теорема}
\newtheorem{Theorem_s}{\hskip\parindent Теорема}[section1]
\newtheorem*{Theorem*}{\hskip\parindent Теорема}
\newtheorem{Lemma}{\hskip\parindent Лемма}
\newtheorem{Proposal}{\hskip\parindent Предложение}
\newtheorem{Proposal_s}{\hskip\parindent Предложение}[section1]
\newtheorem{Corollary}{\hskip\parindent Следствие}
\newtheorem*{Corollary*}{\hskip\parindent Следствие}

\theoremstyle{definition}
\newtheorem{Axiom}{\hskip\parindent Аксиома}
\newtheorem{Example}{\hskip\parindent Пример}
\newtheorem{Definition}{\hskip\parindent Определение}
\newtheorem{Definition_s}{\hskip\parindent Определение}[section1]
\newtheorem*{Remark*}{\hskip\parindent Замечание}
\newtheorem{Remark}{\hskip\parindent Замечание}

\theoremstyle{remark}
%\newtheorem*{Remark}{\hskip\parindent Замечание}
\newtheorem{Case}{\hskip\parindent Случай}





\newcommand{\UDK}[1]{\def\Audk{УДК #1}}
\newcommand{\ArticleNAME}[1]{\def\Aname{#1}}
\newcommand{\ArticleNAMEeng}[1]{\begin{center}\textbf{#1}\end{center}}%\def\Anameeng{#1}}
\newcommand{\ArticleAUTHOR}[1]{\def\Author{#1}}
\newcommand{\ArticleAUTHOReng}[1]{\begin{center}\textit{#1}\end{center}}%\def\Authoreng{#1}}
\newcommand{\ArticleHEAD}[1]{\def\Ahead{#1}}
\newcommand{\ArticleAUTHORHEAD}[1]{\def\Authorhead{#1}}
%\newcommand{\ArticleFOOTNOTE}[1]{\def\Afootnote{#1}}


\renewcommand{\theenumi}{\Alph{enumi}}
\renewcommand \thesection {\arabic{section}.}
\renewcommand \thesubsection {\thesection \arabic{subsection}.}
\renewcommand \thesubsubsection {\thesubsection \arabic{subsubsection}.}

%\renewcommand{\refname}{\begin{center}{\normalsize\rm ЛИТЕРАТУРА}\end{center}}
%\renewcommand{\refname}{\small {ЛИТЕРАТУРА}}
\renewcommand{\@biblabel}[1]{#1. \hfill}

\def\References#1{{\small%
\baselineskip=12pt
%\baselineskip=6pt
\begin{thebibliography}{99}
{#1}\end{thebibliography}}}




\newcounter{myfootnote}[page]
\renewcommand{\@makefnmark}{\hbox{\mathsurround=0pt $^{\@thefnmark }$}}
\newcommand{\absfootnote}[1]{%
  \setcounter{footnote}{\value{myfootnote}}%
  \footnote{{\normalsize #1}}%
  \addtocounter{myfootnote}{1}}

\def\l@contst#1#2{\addpenalty{\@secpenalty}%
   \addvspace{.25em plus\p@}%
   \begingroup
   \@tempdima 3em
     \parindent \z@ \rightskip \@pnumwidth
     \parfillskip -\@pnumwidth
     {\rm
     \leavevmode
     #1\dotfill \hbox to\@pnumwidth{\hss #2}}\par
     \nobreak
   \endgroup}

\def\makeabstitle{ \newpage
%\addtolength{\headheight}{0.45cm}
\thispagestyle{fancy}
\renewcommand{\headrulewidth}{0pt}
\fancyhf{}
%\fancyhead[C]{}
%\fancyhead[C]{~ \vskip14pt \small
\fancyhead[C]{\small
\MakeUppercase {Ученые записки Казанского университета}
\\ \vskip0.5mm \hrule \vskip0.5mm \raggedright
{\sl } \hfill
\centering {Физико-математические науки}
\hfill \raggedleft{\sl }
}
\begingroup
  \setcounter{part}{0}
  \setcounter{section}{0}
  \setcounter{section1}{1}
  \setcounter{subsection}{0}
  \setcounter{figure}{0}
  \setcounter{table}{0}
  \setcounter{equation}{0}
  \setcounter{Theorem}{0}
  \setcounter{Theorem*}{0}
  \setcounter{Lemma}{0}
  \setcounter{Axiom}{0}
  \setcounter{Corollary}{0}
  \setcounter{Corollary*}{0}
  \setcounter{Example}{0}
  \setcounter{Remark}{0}
  \setcounter{Remark*}{0}
  \setcounter{Case}{0}
  \setcounter{Proposal}{0}
  \setcounter{Definition}{0}
  \setcounter{Proposal_s}{0}
  \setcounter{Theorem_s}{0}
  \setcounter{Definition_s}{0}
  \setcounter{footnote}{0}
  \setcounter{tocdepth}{0}
  \setcounter{secnumdepth}{5}
%  \if chapter
%  \setcounter{chapter}{0} \fi
\endgroup
%\vspace*{14pt}
\vspace*{18pt}
\nopagebreak[4]
 \noindent
 \begin{flushleft}%   gggggg
  \Audk
 \end{flushleft}% ggggggg
%  \vspace{1pt}
%  \vspace{-2pt}
  \begin{center}%
    \large \bf \Aname%
%  \if\Afootnote \else %ggggg
%  \footnote{\Afootnote}
%  \fi
  \par%
  \nopagebreak[4]
  \vskip 6pt
   {{\large \it \Author}}
  \vskip 2pt
   \nopagebreak[4]\par%}%
 \end{center}%
 \addcontentsline{toc}{contst}{{\Author}  {\it \Aname}}
 \par
 \nopagebreak[4]
 \vskip .25em
 \nopagebreak[4]
\markboth{\hbox{\MakeUppercase{\small \Ahead}}}{\hbox{\MakeUppercase{\small \Authorhead}}}
 }


\def\headhelp#1#2{\raisebox{0pt}[\headheight][0pt]{\vbox{%
\hbox to \textwidth{#2}\hrule height #1 pt}}}
\renewcommand{\@evenhead}{}
\renewcommand{\@oddhead}{}
\renewcommand{\@oddhead}{%
\headhelp{0.4}{ \hfil \strut \leftmark \hfil \thepage}}
\renewcommand{\@evenhead}{%
\headhelp{0.4}{ \thepage \hfil \strut \rightmark \hfil}}



\renewcommand{\section}{\@startsection{section}{1}%
%{0pt}{3.5ex plus 1ex minus .2ex}%
%{2.3ex plus .2ex}
{0pt}{16pt}%
{4pt}
{\bf \centering }}

\renewcommand\subsection{\@startsection{subsection}{2}{\parindent}%
%{-3.25ex\@plus -1ex \@minus -.2ex}%
{\baselineskip}{0pt}
%{1.5ex \@plus .2ex}%
{\bf } }

\renewcommand\subsubsection{\@startsection{subsubsection}{3}{\parindent}%
%{-3.25ex\@plus -1ex \@minus -.2ex}%
{\baselineskip}{0pt}
%{1.5ex \@plus .2ex}%
{\bf } }

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%  ABSTRACTS          %%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
\renewenvironment{abstract}{%
      \if@twocolumn
        \section*{\abstractname}%
      \else
        \small
        \begin{center}%
          {\bfseries \abstractname%\vspace{\baselineskip}%
          \vspace{-0.4em}%\vspace{\z@}
          }%
        \end{center}%
        \par
        \fi}


% \def\refname{Литература}
% \def\abstractname{Аннотация}


\renewcommand\@dotsep{4.5}
\renewcommand\@pnumwidth{1cm}
%\renewcommand\@pnumwidth{1.55em}
% Чтобы внести в оглавление "Введение" и т.д.
% в текст после \chatper* надо вставить
%      \addcontentsline{toc}{nonumchap}{О слонах...}
%\newcommand{\l@nonumchap}[2]{\hbox to\textwidth {#1 \dotfill#2}}
\newcommand{\l@nonumchap}[2]{%
  \ifnum \c@tocdepth >\m@ne
    \addpenalty{-\@highpenalty}%
%    \vskip 1.0em\@plus\p@
    \vspace{3pt}
%    \setlength\@tempdima{1.5em}%
    \setlength\@tempdima{6em}%
    \begingroup
      \parindent \z@ \rightskip \@pnumwidth
      \parfillskip -\@pnumwidth
      \leavevmode \bfseries
      \advance\leftskip\@tempdima
      \hskip -\leftskip
%      #1\nobreak \hfil \nobreak\hb@xt@\@pnumwidth{\hss #2}\par
      {\rm #1}\nobreak \dotfill \nobreak \hb@xt@\@pnumwidth{\hss {\rm #2}}\par
%      {\rm #1}\nobreak \hfil \nobreak\hb@xt@\@pnumwidth{\hss {\rm #2}}\par
      \penalty\@highpenalty
    \endgroup
  \fi}

\renewcommand{\refname}{\small {Литература}} \renewcommand{\abstractname}{Аннотация} \renewcommand{\figurename}{Рис.}
\renewcommand{\proofname}{{\hskip\parindent \bf Доказательство. }}

\endinput
