package Categories;

import java.util.Random;
import Backend.*;

public class Vocab extends Category
{
	Random rand;
	boolean askDef;

	public Vocab()
	{
		rand = new Random();
		askDef = true;
	}

	public Vocab(boolean ad)
	{
		rand = new Random();
		askDef = ad;
	}

	public static final String wordDef[] = {
		"plenary","full, complete, entire, absolute, unqualified; attended by all qualified members",
		"multiplex","having many parts; using a single resource to satisfy many requests",
		"prestigious","having a high reputation, honored, esteemed",
		"satorial","relating to a tailor, tailoring, clothing, style or manner of dress",
		"paradigm","an example serving as a model, pattern; mold, standard; ideal, paragon",
		"risible","exciting or provoking laughter",
		"dictum","an authoritative statement",
		"skulk","to hide in a sneaking manner",
		"unguent","an ointment",
		"machination","a crafty scheme intended to accomplish some usually evil end",
		"debouch","to emerge; to issue",
		"pernicious","causing insidious harm or ruin; deadly, fatal",
		"paragon (v)","to compare; to parallel; to be a match for; to rival",
		"paragon (n)","a model or pattern of excellence,an unusually large, round pearl",
		"galvanic","shocking; pertaining to a direct current of electricity",
		"vapid","flat, dull, spiritless",
		"avoirdupois","weight, heaviness",
		"equivocate","to be deliberately ambiguous or unclear",
		"redact","to edit",
		"trencherman","a hearty eater",
		"solicit","to formally or respectfully seek or petition for something desired",
		"importune","to make urgent or persistent solicitations; to beg; to make advances",
		"mollify","to reduce in intensity; to soothe; to soften",
		"abstruse","hard to understand, recondite, esoteric",
		"recondite","beyond ordinary knowledge, esoteric; dealing with abstruse matters",
		"esoteric","only for the select few, recondite; private, secret, confidential", 
		"ostensible","apparent, evident, conspicuous; outwardly appearing as such, pretended",
		"castigate","to criticize or reprimand severely; to punish in order to correct",
		"arable","land that can be or is cultivated; suitable for farming",
		"subaltern","subordinate; inferior",
		"exacerbate","to aggravate; to make worse",
		"derogate","to become degenerate, go astray; to disparage or belittle",
		"disparage","to belittle; to bring reproach or discredit upon, demean, mock",
		"depreciate","to decline in value; to reduce in price",
		"deprecate","to disparage, belittle, urge reasons against, condemn, denounce",
		"diffident","lacking self-confidence, shy, timid; also restrained or reserved in manner",
		"proclivity","a natural inclination; predisposition",
		"inconspicuous","not prominent or noticeable",
		"conspicuous","easily noticed, readily visible; attracting special attention",
		"ostentatious","a pretentious or conspicuous attempt to impress",
		"pretentious","assuming dignitiy or importance; showy; ostentatious",
		"surreptitious","done by stealth; secret or unauthorized; clandestine",
		"clandestine","executed with secrecy an concealment; private, surreptitious",
		"bombastic","high-sounding, high-flown, inflated, pretentious",
		"moot (a)","debatable; doubtful; purely academic",
		"moot (v)","to introduce a topic for discussion; or, to make purely academic",
		"capricious","impulsive; erratic; whimsical",
		"bootless","unavailing; useless",
		"dotage","feebleness of mind due to old age; senility",
		"cosmopolitan","worldly; sophisticated",
		"countenance","facial expression; or, approval or support; to tolerate",
		"covenant","agreement; solemn pledge or contract",
		"disassemble","to take apart; to come apart",
		"dissemble","to conceal the truth or real nature of; to feign",
		"putative","commonly thought or deemed; supposed",
		"remunerative","yielding suitable recompense; profitable",
		"lucrative","profitable; moneymaking; remunerative",
		"inexorable","unyielding; relentless",
		"aerugo","verdigris; a green or blue patina consisting of basic copper sulfate",
		"verdigris","aerugo; a green or bluish patina on long exposed copper, brass, or bronze",
		"patina","a (usually) green film or incrustation from oxidation on old bronze",
		"equivocal","having multiple interpretations, esp. w/ intent to deceive",
		"univocal","having only one meaning; unambiguous",
		"discrete","apart or detached, seperate, distinct; discontinuous",
		"discreet","marked by prudence and wise self restraint, circumspect; modest",
		"gauche","lacking social polish, tactless, awkward, clumsy",
		"ab ovo","from the beginning",
		"idyll","a literary work depicting rural life; a carefree episode or experience",
		"epidemic","affecting many persons at the same time, widespread",
		"endemic","indigenous, natural or characteristic of a people or place",
		"ingenious","clever, inventive, resourceful",
		"ingenuous","candid, sincere; also artless, innocent, naive",
		"turgid","swollen, bloated; also bombastic, pompous",
		"peripatetic","walking about or travelling from place to place",
		"vicious","spiteful, malicious, savage, ferocious",
		"viscous","resistant to flow, sticky, thick, adhesive",
		"congeries","a collection, an aggregation",
		"agrestic","pertaining to fields or the countryside",
		"obfuscate","to darken or obscure",
		"copse","a thicket of small trees",
		"harangue","a speech addressed to a public assembly; a noisy or pompous speech",
		"simulacrum","a representation; an insubstantial or vague semblance",
		"putative","commonly thought or deemed, supposed",
		"vitiate","to make faulty or imperfect",
		"daedal","skillful, artistic, ingenious",
		"autocrat","a ruler with unlimited authority",
		"comestible","suitable to be eaten",
		"objurgate","to scold or rebuke sharply",
		"sardonic","scornful, mocking",
		"lexicon","a dictionary; the vocabulary of a person, group, etc",
		"contemporaneous","originating, existing, or occurring at the same time",
		"panoply","a splendid or impressive array",
		"supererogatory","going beyond what is required or expected; superfluous, unnecessary",
		"comity","a state of mutual harmony, friendship, and respect",
		"eleemosynary","relating to charity, charitable",
		"inclement","harsh, severe",
		"hugger-mugger","secret; muddled, disorderly",
		"genial","sympathetically cheerful and cheering, kindly",
		"florid","flushed with red; also, excessively ornate",
		"sapient","wise, sage, discerning",
		"disparate","fundamentally different, also, composed of dissimilar elements",
		"prevaricate","to depart from or evade the truth",
		"inveigle","to persuade or obtain by ingenuity or flattery",
		"harridan","a scolding, vicious woman",
		"segue","to proceed without interruption, to make a smooth transition",
		"lascivious","lewd, lustful",
		"visage","the face; also, appearance, aspect",
		"lugubrious","mournful, gloomy, dismal",
		"interstice","a space between things or parts",
		"sempiternal","everlasting, eternal",
		"idee fixe","a fixed idea; an obsession",
		"prestidigitation","sleight of hand",
		"apocryphal","not canonical; of doubtful authority or authenticity",
		"fillip","a snap; also, a stimulus",
		"ostracize","to banish or expel",
		"thaumaturgy","the performing of miracles or magic",
		"paucity","fewness, insufficiency",
		"encomium","expression of praise",
		"requisite","required; indispensable",
		"toper","a drunkard; a sot",
		"plaint","an expression of sorrow; also, a complaint",
		"travail","painful, arduous work; also, agony, anguish",
		"alacrity","a cheerful readiness, willingness, or promptness",
		"disheveled","in loose disorder; disarranged",
		"junta","a governmental council or committee, esp. one that rules after a revolution",
		"respite","an interval of rest or relief",
		"wheedle","to entice by flattery",
		"febrile","feverish",
		"habitue","one who habitually frequents a place",
		"Pyrrhic victory","a victory achieved at great cost",
		"animadversion","harsh criticism or disapproval",
		"encumbrance","a burden, impediment, or hindrance",
		"copious","large in quantity; also, affording an abundant supply",
		"impugn","to call in question; to make insinuations against",
		"ascetic","one who practices extreme self-denial; also, austere, severe",
		"aggrandize","to make or make appear great or greater",
		"syncretic","uniting and blending together different belief systems",
		"donnybrook","a brawl or dispute",
		"surcease","cessation; stop; end",
		"perquisite","a gratuity or tip; a benefit in addition to a salary",
		"scion","a descendant; an heir",
		"proselytize","to convert (someone) to another religion, belief, etc",
		"abattoir","a slaughterhouse",
		"tchotchke","a trinket; a knickknack",
		"factitious","artificial; not authentic or genuine",
		"puerile","juvenile; childish",
		"nadir","the lowest point",
		"effulgence","the state of being bright and radiant",
		"inchoate","partly but not fully in existence or operation",
		"beneficence","the practice of doing good",
		"sempiternal","everlasting; eternal",
		"onus","burden; also, blame; stigma",
		"abstemious","temperate; abstinent; refraining from indulgence",
		"cant","empty, solemn speech",
		"laconic","using or marked by the use of a minimum of words",
		"palpable","plain; distinct; obvious",
		"gewgaw","a trinket; a bauble",
		"conurbation","an aggregation or continuous network of urban communities",
		"sinecure","an office or position that involves little work or responsibility",
		"abjure","to renounce, reject, or shun",
		"lackadaisical","lacking spirit or liveliness",
		"aberrant","abnormal",
		"votary","one devoted to some pursuit, worship, study, or way of life",
		"pelf","money; riches",
		"tocsin","a warning",
		"lexicon","a dictionary; also, the vocabulary of a person, group, etc",
		"umbrage","offense; resentment",
		"orotund","full in sound; also, bombastic",
		"loquacious","very talkative",
		"bruit","to report; to spread news of; to repeat",
		"virago","an ill-tempered, overbearing woman; a woman of great strength and courage",
		"mawkish","sickly or excessively sentimental",
		"malediction","a curse",
		"susurrus","a whispering or rustling sound",
		"neophyte","a novice",
		"immolate","to kill or destroy, often by fire",
		"lugubrious","mournful, gloomy, dismal",
		"ostracize","to banish or expel",
		"prevaricate","to depart from or evade the truth"};

	public Question nextQuestion()
	{
		int index = rand.nextInt(wordDef.length/2);
		String word = wordDef[2*index];
		String def = wordDef[2*index + 1];

		String q;
		String a;

		if(askDef)
		{
			q = "What is the definition of " + word + "? ";
			a = def;
		}
		else
		{
			q = def + " is the definition of what word? ";
			a = word;
		}

		return new Question(q,a);
	}
}
